package com.immediateactiongroup.issues.commons.constant;

/**
 * Created by beishan on 2017/9/2.
 */
public interface UserConstant {

    enum UserAccess{
        DISABLE(0),
        ENABLE(1)
        ;

        private int value;

        UserAccess(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }
}
