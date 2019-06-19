package com.daka.webserver.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SysUserExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Long offset;

    public SysUserExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setOffset(Long offset) {
        this.offset = offset;
    }

    public Long getOffset() {
        return offset;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andUserIdIsNull() {
            addCriterion("USER_ID is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("USER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(String value) {
            addCriterion("USER_ID =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(String value) {
            addCriterion("USER_ID <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(String value) {
            addCriterion("USER_ID >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("USER_ID >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(String value) {
            addCriterion("USER_ID <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(String value) {
            addCriterion("USER_ID <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLike(String value) {
            addCriterion("USER_ID like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotLike(String value) {
            addCriterion("USER_ID not like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<String> values) {
            addCriterion("USER_ID in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<String> values) {
            addCriterion("USER_ID not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(String value1, String value2) {
            addCriterion("USER_ID between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(String value1, String value2) {
            addCriterion("USER_ID not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andSecretidIsNull() {
            addCriterion("SECRETID is null");
            return (Criteria) this;
        }

        public Criteria andSecretidIsNotNull() {
            addCriterion("SECRETID is not null");
            return (Criteria) this;
        }

        public Criteria andSecretidEqualTo(String value) {
            addCriterion("SECRETID =", value, "secretid");
            return (Criteria) this;
        }

        public Criteria andSecretidNotEqualTo(String value) {
            addCriterion("SECRETID <>", value, "secretid");
            return (Criteria) this;
        }

        public Criteria andSecretidGreaterThan(String value) {
            addCriterion("SECRETID >", value, "secretid");
            return (Criteria) this;
        }

        public Criteria andSecretidGreaterThanOrEqualTo(String value) {
            addCriterion("SECRETID >=", value, "secretid");
            return (Criteria) this;
        }

        public Criteria andSecretidLessThan(String value) {
            addCriterion("SECRETID <", value, "secretid");
            return (Criteria) this;
        }

        public Criteria andSecretidLessThanOrEqualTo(String value) {
            addCriterion("SECRETID <=", value, "secretid");
            return (Criteria) this;
        }

        public Criteria andSecretidLike(String value) {
            addCriterion("SECRETID like", value, "secretid");
            return (Criteria) this;
        }

        public Criteria andSecretidNotLike(String value) {
            addCriterion("SECRETID not like", value, "secretid");
            return (Criteria) this;
        }

        public Criteria andSecretidIn(List<String> values) {
            addCriterion("SECRETID in", values, "secretid");
            return (Criteria) this;
        }

        public Criteria andSecretidNotIn(List<String> values) {
            addCriterion("SECRETID not in", values, "secretid");
            return (Criteria) this;
        }

        public Criteria andSecretidBetween(String value1, String value2) {
            addCriterion("SECRETID between", value1, value2, "secretid");
            return (Criteria) this;
        }

        public Criteria andSecretidNotBetween(String value1, String value2) {
            addCriterion("SECRETID not between", value1, value2, "secretid");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNull() {
            addCriterion("USER_NAME is null");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNotNull() {
            addCriterion("USER_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andUserNameEqualTo(String value) {
            addCriterion("USER_NAME =", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotEqualTo(String value) {
            addCriterion("USER_NAME <>", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThan(String value) {
            addCriterion("USER_NAME >", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("USER_NAME >=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThan(String value) {
            addCriterion("USER_NAME <", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThanOrEqualTo(String value) {
            addCriterion("USER_NAME <=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLike(String value) {
            addCriterion("USER_NAME like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotLike(String value) {
            addCriterion("USER_NAME not like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameIn(List<String> values) {
            addCriterion("USER_NAME in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotIn(List<String> values) {
            addCriterion("USER_NAME not in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameBetween(String value1, String value2) {
            addCriterion("USER_NAME between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotBetween(String value1, String value2) {
            addCriterion("USER_NAME not between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserPhotoPathIsNull() {
            addCriterion("USER_PHOTO_PATH is null");
            return (Criteria) this;
        }

        public Criteria andUserPhotoPathIsNotNull() {
            addCriterion("USER_PHOTO_PATH is not null");
            return (Criteria) this;
        }

        public Criteria andUserPhotoPathEqualTo(String value) {
            addCriterion("USER_PHOTO_PATH =", value, "userPhotoPath");
            return (Criteria) this;
        }

        public Criteria andUserPhotoPathNotEqualTo(String value) {
            addCriterion("USER_PHOTO_PATH <>", value, "userPhotoPath");
            return (Criteria) this;
        }

        public Criteria andUserPhotoPathGreaterThan(String value) {
            addCriterion("USER_PHOTO_PATH >", value, "userPhotoPath");
            return (Criteria) this;
        }

        public Criteria andUserPhotoPathGreaterThanOrEqualTo(String value) {
            addCriterion("USER_PHOTO_PATH >=", value, "userPhotoPath");
            return (Criteria) this;
        }

        public Criteria andUserPhotoPathLessThan(String value) {
            addCriterion("USER_PHOTO_PATH <", value, "userPhotoPath");
            return (Criteria) this;
        }

        public Criteria andUserPhotoPathLessThanOrEqualTo(String value) {
            addCriterion("USER_PHOTO_PATH <=", value, "userPhotoPath");
            return (Criteria) this;
        }

        public Criteria andUserPhotoPathLike(String value) {
            addCriterion("USER_PHOTO_PATH like", value, "userPhotoPath");
            return (Criteria) this;
        }

        public Criteria andUserPhotoPathNotLike(String value) {
            addCriterion("USER_PHOTO_PATH not like", value, "userPhotoPath");
            return (Criteria) this;
        }

        public Criteria andUserPhotoPathIn(List<String> values) {
            addCriterion("USER_PHOTO_PATH in", values, "userPhotoPath");
            return (Criteria) this;
        }

        public Criteria andUserPhotoPathNotIn(List<String> values) {
            addCriterion("USER_PHOTO_PATH not in", values, "userPhotoPath");
            return (Criteria) this;
        }

        public Criteria andUserPhotoPathBetween(String value1, String value2) {
            addCriterion("USER_PHOTO_PATH between", value1, value2, "userPhotoPath");
            return (Criteria) this;
        }

        public Criteria andUserPhotoPathNotBetween(String value1, String value2) {
            addCriterion("USER_PHOTO_PATH not between", value1, value2, "userPhotoPath");
            return (Criteria) this;
        }

        public Criteria andUserDataPathIsNull() {
            addCriterion("USER_DATA_PATH is null");
            return (Criteria) this;
        }

        public Criteria andUserDataPathIsNotNull() {
            addCriterion("USER_DATA_PATH is not null");
            return (Criteria) this;
        }

        public Criteria andUserDataPathEqualTo(String value) {
            addCriterion("USER_DATA_PATH =", value, "userDataPath");
            return (Criteria) this;
        }

        public Criteria andUserDataPathNotEqualTo(String value) {
            addCriterion("USER_DATA_PATH <>", value, "userDataPath");
            return (Criteria) this;
        }

        public Criteria andUserDataPathGreaterThan(String value) {
            addCriterion("USER_DATA_PATH >", value, "userDataPath");
            return (Criteria) this;
        }

        public Criteria andUserDataPathGreaterThanOrEqualTo(String value) {
            addCriterion("USER_DATA_PATH >=", value, "userDataPath");
            return (Criteria) this;
        }

        public Criteria andUserDataPathLessThan(String value) {
            addCriterion("USER_DATA_PATH <", value, "userDataPath");
            return (Criteria) this;
        }

        public Criteria andUserDataPathLessThanOrEqualTo(String value) {
            addCriterion("USER_DATA_PATH <=", value, "userDataPath");
            return (Criteria) this;
        }

        public Criteria andUserDataPathLike(String value) {
            addCriterion("USER_DATA_PATH like", value, "userDataPath");
            return (Criteria) this;
        }

        public Criteria andUserDataPathNotLike(String value) {
            addCriterion("USER_DATA_PATH not like", value, "userDataPath");
            return (Criteria) this;
        }

        public Criteria andUserDataPathIn(List<String> values) {
            addCriterion("USER_DATA_PATH in", values, "userDataPath");
            return (Criteria) this;
        }

        public Criteria andUserDataPathNotIn(List<String> values) {
            addCriterion("USER_DATA_PATH not in", values, "userDataPath");
            return (Criteria) this;
        }

        public Criteria andUserDataPathBetween(String value1, String value2) {
            addCriterion("USER_DATA_PATH between", value1, value2, "userDataPath");
            return (Criteria) this;
        }

        public Criteria andUserDataPathNotBetween(String value1, String value2) {
            addCriterion("USER_DATA_PATH not between", value1, value2, "userDataPath");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("CREATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("CREATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("CREATE_TIME =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("CREATE_TIME <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("CREATE_TIME >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("CREATE_TIME >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("CREATE_TIME <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("CREATE_TIME <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("CREATE_TIME in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("CREATE_TIME not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("CREATE_TIME between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("CREATE_TIME not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("UPDATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("UPDATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("UPDATE_TIME =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("UPDATE_TIME <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("UPDATE_TIME >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("UPDATE_TIME >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("UPDATE_TIME <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("UPDATE_TIME <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("UPDATE_TIME in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("UPDATE_TIME not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("UPDATE_TIME between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("UPDATE_TIME not between", value1, value2, "updateTime");
            return (Criteria) this;
        }
    }

    /**
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}