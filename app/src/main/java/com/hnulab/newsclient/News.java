package com.hnulab.newsclient;

/**
 * 作者：luojie
 * 邮箱：550997728@qq.com
 * 时间：2017/1/14 13:35
 */
public class News {
          private String title;
          private String description;
          private String image;
          private String type;
          private String comment;

          public String getType() {
                    return type;
          }

          public void setType(String type) {
                    this.type = type;
          }

          public String getComment() {
                    return comment;
          }

          public void setComment(String comment) {
                    this.comment = comment;
          }

          public String getDescription() {
                    return description;
          }

          public void setDescription(String description) {
                    this.description = description;
          }

          public String getImage() {
                    return image;
          }

          public void setImage(String image) {
                    this.image = image;
          }

          public String getTitle() {
                    return title;
          }

          public void setTitle(String title) {
                    this.title = title;
          }
}
