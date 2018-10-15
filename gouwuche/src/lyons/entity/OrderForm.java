package lyons.entity;

import java.util.Date;

/**
 * 
 * 订单实体类
 * 
 * @author  Lyons(tzh)
 * @version  [版本号, 2016 6 3]
 * @since  [应用/版本]
 */
public class OrderForm
{
    private int id = 0;
    private String username = "";
    private Date orderDate = null;
    private String commodity_name = "";
    private double commodity_price = 0.00;
    private int sum = 0;                    //总数
    /**
     * <p>
     * 无参构造器
     * </p>
     * 
     */
    public OrderForm(){}
   /**
    * ID返回 
    * @return id
    */
    public int getId()
    {
        return id;
    }
    /**
     * 设置id
     * @param id
     */
    public void setId(int id)
    {
        this.id = id;
    }
    /**
     * 获取用户名
     * @return username
     */
    public String getUsername()
    {
        return username;
    }
    /**
     * 设置用户名
     * @param username
     */
    public void setUsername(String username)
    {
        this.username = username;
    }
    /**
     * 日期类
     * @return orderDate
     */
    public Date getOrderDate()
    {
        return orderDate;
    }
    /**
     * 日期类
     * @param orderDate
     */
    public void setOrderDate(Date orderDate)
    {
        this.orderDate = orderDate;
    }
    /**
     * 返回商品名称
     * @return getCommodity_name
     */
    public String getCommodity_name()
    {
        return commodity_name;
    }
    /**
     * 设置商品名称
     * @param commodity_name
     */
    public void setCommodity_name(String commodity_name)
    {
        this.commodity_name = commodity_name;
    }
    /**
     * 商品价格
     * @return
     */
    public double getCommodity_price()
    {
        return commodity_price;
    }
    /**
     * 设置商品价格
     * @param commodity_price
     */
    public void setCommodity_price(double commodity_price)
    {
        this.commodity_price = commodity_price;
    }
    /**
     * 商品总数
     * @return 总数sum
     */
    public int getSum()
    {
        return sum;
    }
    /**
     * 设置商品总数
     * @param sum
     * 
     */
    public void setSum(int sum)
    {
        this.sum = sum;
    }
 
    
}
