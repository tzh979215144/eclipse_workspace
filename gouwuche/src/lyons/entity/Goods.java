package lyons.entity;


import com.sun.rowset.CachedRowSetImpl;

/**
 * 商品实体类
 * @author lyons(tzh)
 *
 */
public class Goods 
{
	/**
	 * 表中所有的行集对象
	 */
	CachedRowSetImpl rowSet = null; 
	/**
	 * 每页显示多少条记录(默认为5条)
	 */
	private int pageSize = 5;	
	/**
	 * 当前页数
	 */
	private int currentPage = 1;
	/**
	 * 总记录数
	 */
	private int totalRecord = 1;
	/**
	 * 总页数
	 */
	private int totalPage = 1;	 
	
	public Goods(){}
	/**
	 * 构造器实现给对象传值
	 * @param rowSet
	 * @param pageSize
	 * @param currentPage
	 * @param totalPRecord
	 * @param totalPage
	 */
	public Goods(CachedRowSetImpl rowSet, int pageSize, int currentPage,
			int totalPRecord, int totalPage)
	{
		this.rowSet = rowSet;
		this.pageSize = pageSize;
		this.currentPage = currentPage;
		this.totalRecord = totalPRecord;
		this.totalPage = totalPage;
	}
/**
 * CachedRowSetlmpl对象不依赖Connnection对象
 * 一旦ResulSet对象中的数据保存到CachedRowSetlmpl对象
 * 就可以关闭和数据库的连接。CachedRowSetlmpl继承了ResulSet的所有方法
 * 所以可以和ResulSet的对象一样操作数据。
 * @return
 */
    public CachedRowSetImpl getRowSet()
    {
        return rowSet;
    }

    public void setRowSet(CachedRowSetImpl rowSet)
    {
        this.rowSet = rowSet;
    }

    public int getPageSize()
    {
        return pageSize;
    }

    public void setPageSize(int pageSize)
    {
        this.pageSize = pageSize;
    }

    public int getCurrentPage()
    {
        return currentPage;
    }

    public void setCurrentPage(int currentPage)
    {
        this.currentPage = currentPage;
    }

    public int getTotalRecord()
    {
        return totalRecord;
    }

    public void setTotalRecord(int totalRecord)
    {
        this.totalRecord = totalRecord;
    }

    public int getTotalPage()
    {
        return totalPage;
    }

    public void setTotalPage(int totalPage)
    {
        this.totalPage = totalPage;
    }

	
}
