package io.itracybryant.initializestarter.pojo;

import javax.persistence.*;

@Table(name = "it_item")
public class ItItem {
    @Id
    private Integer id;

    /**
     * 品种
     */
    private String variety;

    /**
     * 标的
     */
    private String authorization;

    /**
     * 标的价格
     */
    @Column(name = "subject_price")
    private String subjectPrice;

    /**
     * 买价
     */
    @Column(name = "bid_price")
    private String bidPrice;

    /**
     * 卖价
     */
    @Column(name = "sell_price")
    private String sellPrice;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取品种
     *
     * @return variety - 品种
     */
    public String getVariety() {
        return variety;
    }

    /**
     * 设置品种
     *
     * @param variety 品种
     */
    public void setVariety(String variety) {
        this.variety = variety;
    }

    /**
     * 获取标的
     *
     * @return authorization - 标的
     */
    public String getAuthorization() {
        return authorization;
    }

    /**
     * 设置标的
     *
     * @param authorization 标的
     */
    public void setAuthorization(String authorization) {
        this.authorization = authorization;
    }

    /**
     * 获取标的价格
     *
     * @return subject_price - 标的价格
     */
    public String getSubjectPrice() {
        return subjectPrice;
    }

    /**
     * 设置标的价格
     *
     * @param subjectPrice 标的价格
     */
    public void setSubjectPrice(String subjectPrice) {
        this.subjectPrice = subjectPrice;
    }

    /**
     * 获取买价
     *
     * @return bid_price - 买价
     */
    public String getBidPrice() {
        return bidPrice;
    }

    /**
     * 设置买价
     *
     * @param bidPrice 买价
     */
    public void setBidPrice(String bidPrice) {
        this.bidPrice = bidPrice;
    }

    /**
     * 获取卖价
     *
     * @return sell_price - 卖价
     */
    public String getSellPrice() {
        return sellPrice;
    }

    /**
     * 设置卖价
     *
     * @param sellPrice 卖价
     */
    public void setSellPrice(String sellPrice) {
        this.sellPrice = sellPrice;
    }
}