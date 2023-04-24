package algorithm;

import java.util.*;
import java.util.List;

public class Dendrogram
{
    private final DendrogramNode root;

    public Dendrogram(DendrogramNode r)
    {
        this.root = r;
    }

    @Override
    public String toString()
    {
        return String.format("%s %s", this.root.toString(), this.root.getMerges());
    }

    public List<String> getMerges()
    {
        List<String> res = this.root.getMerges();

        Collections.reverse(res);

        return res;
    }

    static abstract class DendrogramNode
    {
        @Override
        public abstract String toString();

        protected abstract List<InputObject> getObjects();

        public abstract List<String> getMerges();
    }

    static class DendrogramBranch extends DendrogramNode
    {
        private final DendrogramNode left;
        private final DendrogramNode right;

        public DendrogramBranch(DendrogramNode l, DendrogramNode r)
        {
            this.left = l; this.right = r;
        }

        @Override
        public String toString()
        {
            return String.format("( %s %s )", this.left, this.right);
        }

        protected List<InputObject> getObjects()
        {
            List<InputObject> res = new ArrayList<>(this.left.getObjects());

            res.addAll(this.right.getObjects());

            return res;
        }

        public List<String> getMerges()
        {
            List<String> res = new ArrayList();

            res.addAll(this.left.getMerges());
            res.addAll(this.right.getMerges());
            res.add(String.format("%s + %s", this.left.getObjects(), this.right.getObjects()));

            return res;
        }
    }

    static class DendrogramLeaf extends DendrogramNode
    {
        private final InputObject point;

        public DendrogramLeaf(InputObject o)
        {
            this.point = o;
        }

        @Override
        public String toString()
        {
            return this.point.toString();
        }

        protected List<InputObject> getObjects()
        {
            return List.of(this.point);
        }

        public List<String> getMerges()
        {
            return List.of();
        }
    }
}
