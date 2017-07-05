/**********************************************************
 * Created at 2016/7/7
 * <p>
 * Author:	JiaweiMao
 * <p>
 * Copyright (c) Dalian Institute of Chemical Physics
 * Chinese Academy of Sciences
 * <p>
 * Contact: jiawei@dicp.ac.cn
 *******************************************************/
package test.jdk.util;

import java.util.HashMap;

/**
 * @author JiaweiMao
 * @version 1.00
 * @date Jul 07 2016, 18:58
 */
public class ObjectWrapper {

    public HashMap<Integer, Double> values;

    public ObjectWrapper() {
        values = new HashMap<>();
    }

    public void addValue(int key, Double value) {
        values.put(key, value);
    }
}
