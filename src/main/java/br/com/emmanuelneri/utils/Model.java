package br.com.emmanuelneri.utils;

import java.io.Serializable;

public interface Model<ID extends Serializable> extends Serializable {

    ID getId();
}
