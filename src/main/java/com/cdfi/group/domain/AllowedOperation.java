package com.cdfi.group.domain;


import com.google.gson.annotations.SerializedName;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public enum AllowedOperation {
    @SerializedName("READ")
    READ {
        public boolean containsHttpMethod(String httpMethod) {
            return httpMethod.equalsIgnoreCase("get") || httpMethod.equalsIgnoreCase("head");
        }
    },
    @SerializedName("CHANGE")
    CHANGE {
        public boolean containsHttpMethod(String httpMethod) {
            return httpMethod.equalsIgnoreCase("post") || httpMethod.equalsIgnoreCase("put");
        }
    },
    @SerializedName("DELETE")
    DELETE {
        public boolean containsHttpMethod(String httpMethod) {
            return httpMethod.equalsIgnoreCase("delete");
        }
    };

    public static final Set<AllowedOperation> ALL = Collections.unmodifiableSet(new HashSet<AllowedOperation>() {
        {
            this.add(AllowedOperation.READ);
            this.add(AllowedOperation.CHANGE);
            this.add(AllowedOperation.DELETE);
        }
    });

    private AllowedOperation() {
    }

    public abstract boolean containsHttpMethod(String var1);
}

