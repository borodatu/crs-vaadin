package com.copyright.domain;

import com.copyright.api.Article;

/**
 * //TODO class description
 * <p/>
 * Date: 1/10/12
 *
 * @author Nikita Levyankov
 */
public class ArticleImpl implements Article {

    private Integer id;

    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
