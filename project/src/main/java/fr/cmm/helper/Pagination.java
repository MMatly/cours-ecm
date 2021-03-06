package fr.cmm.helper;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

public class Pagination {
    // 1 based page index
    private int pageIndex;

    private int pageSize;

    private long count;

    public static final int PAGINATION_SIZE = 10;

    public int getPreviousPageIndex() {
        return isFirstPage() ? pageIndex : pageIndex - 1;
    }

    public int getNextPageIndex() {
        return isLastPage() ? pageIndex : pageIndex + 1;
    }

    public boolean isFirstPage() {
        return pageIndex == 1;
    }

    public boolean isLastPage() {
        return pageIndex * pageSize >= count;
    }

    public int getPageCount() {

        float mod=count % pageSize;
        if(count == 0)
        {
            return(0);
        }
        else
        {
            if(mod == 0)

            {
                return (int) count/ pageSize;
            }
            else {
                if (count < pageSize) {
                    return (1);
                } else {
                    return (int) count / pageSize;
                }
            }
        }

    }

    public List<Integer> getPages() {
        int nbPages = getPageCount();
        if (nbPages>PAGINATION_SIZE)
        {
            nbPages = PAGINATION_SIZE;
        }
        List<Integer> L = new ArrayList<Integer>();
        for( int i = 1; i<=nbPages ;i++){
            L.add(i);
        }
        return L;

    }

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }
}
