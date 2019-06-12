package exam;

import java.util.ArrayList;
import java.util.List;

// TODO: 完成这个类

public class PaginationHelper<I> {
     List<I> collection=new ArrayList<>();
     int itemsPerPage;
    /**
     * 构造函数包含
     * 1）数组collection，表示需要分页的所有元素
     * 2）数字itemsPerPage，表示每页的元素个数
     */
    public PaginationHelper(List<I> collection, int itemsPerPage) {
     this.collection=collection;
     this.itemsPerPage=itemsPerPage;
    }

    /**
     * 返回collection中所有元素的个数
     */
    public int itemCount() {
        if(collection.size()>0)
        return collection.size();
        else
        throw new RuntimeException();
    }

    /**
     * 返回页数
     */
    public int pageCount() {
        int Count=collection.size();
        int allpages=Count/itemsPerPage+1;
        if (allpages>-1)
        return  allpages;
        throw new RuntimeException();
    }

    /**
     * 返回当前页pageIndex中所包含的元素个数
     * pageIndex从0开始计数
     * 如果pageIndex为非法值则返回-1
     */
    public int pageItemCount(int pageIndex) {
        int Count=collection.size();
        int allpages=0;
        if (Count%itemsPerPage!=0)
            allpages=Count/itemsPerPage+1;
        else
            allpages=Count/itemsPerPage;
        if (pageIndex+1<allpages)
            return itemsPerPage;
       if (pageIndex+1==allpages)
           return itemsPerPage*allpages-Count;
       if (pageIndex+1>allpages) return -1;
        throw new RuntimeException();
    }

    /**
     * 返回第itemIndex个元素所在的页数
     * pageIndex从0开始计数
     * 如果itemIndex为非法值则返回-1
     */
    public int pageIndex(int itemIndex) {
        int pageindex=itemIndex/itemsPerPage+1;
        if (pageindex>0&&pageindex<collection.size()+1)
        return pageindex;
        else if(pageindex<0||pageindex>collection.size())
            return -1;
        throw new RuntimeException();
    }
}