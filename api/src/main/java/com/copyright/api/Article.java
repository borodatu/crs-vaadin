package com.copyright.api;

import java.io.Serializable;

/**
 * //TODO class description
 * <p/>
 * Date: 1/10/12
 *
 * @author Nikita Levyankov
 */
public interface Article extends Serializable {

    Integer getId();

    void setId(Integer id);

    String getName();

    void setName(String name);
}
