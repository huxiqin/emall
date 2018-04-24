package com.xzf.org.emall.domain

class Goods {

    Integer id
    //类目id
    Integer catId
    //商品标题
    String title
    //商品图片ID
    String mainImageIds
    //商品描述
    String description
    //商品价格
    BigDecimal price
    //商品上下价状态
    Integer shelveStatus

    String createdBy

    String updatedBy

    Date createdDate

    Date updatedDate

    Integer isDelete


    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", catId=" + catId +
                ", title='" + title + '\'' +
                ", mainImageIds='" + mainImageIds + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", shelveStatus=" + shelveStatus +
                ", createdBy='" + createdBy + '\'' +
                ", updatedBy='" + updatedBy + '\'' +
                ", createdDate=" + createdDate +
                ", updatedDate=" + updatedDate +
                ", isDelete=" + isDelete +
                '}';
    }
}
