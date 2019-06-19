package com.daka.webserver.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SysControllExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Long offset;

    public SysControllExample() {
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

        public Criteria andSecretidIsNull() {
            addCriterion("sys_controll.SECRETID is null");
            return (Criteria) this;
        }

        public Criteria andSecretidIsNotNull() {
            addCriterion("sys_controll.SECRETID is not null");
            return (Criteria) this;
        }

        public Criteria andSecretidEqualTo(String value) {
            addCriterion("sys_controll.SECRETID =", value, "secretid");
            return (Criteria) this;
        }

        public Criteria andSecretidNotEqualTo(String value) {
            addCriterion("sys_controll.SECRETID <>", value, "secretid");
            return (Criteria) this;
        }

        public Criteria andSecretidGreaterThan(String value) {
            addCriterion("sys_controll.SECRETID >", value, "secretid");
            return (Criteria) this;
        }

        public Criteria andSecretidGreaterThanOrEqualTo(String value) {
            addCriterion("sys_controll.SECRETID >=", value, "secretid");
            return (Criteria) this;
        }

        public Criteria andSecretidLessThan(String value) {
            addCriterion("sys_controll.SECRETID <", value, "secretid");
            return (Criteria) this;
        }

        public Criteria andSecretidLessThanOrEqualTo(String value) {
            addCriterion("sys_controll.SECRETID <=", value, "secretid");
            return (Criteria) this;
        }

        public Criteria andSecretidLike(String value) {
            addCriterion("sys_controll.SECRETID like", value, "secretid");
            return (Criteria) this;
        }

        public Criteria andSecretidNotLike(String value) {
            addCriterion("sys_controll.SECRETID not like", value, "secretid");
            return (Criteria) this;
        }

        public Criteria andSecretidIn(List<String> values) {
            addCriterion("sys_controll.SECRETID in", values, "secretid");
            return (Criteria) this;
        }

        public Criteria andSecretidNotIn(List<String> values) {
            addCriterion("sys_controll.SECRETID not in", values, "secretid");
            return (Criteria) this;
        }

        public Criteria andSecretidBetween(String value1, String value2) {
            addCriterion("sys_controll.SECRETID between", value1, value2, "secretid");
            return (Criteria) this;
        }

        public Criteria andSecretidNotBetween(String value1, String value2) {
            addCriterion("sys_controll.SECRETID not between", value1, value2, "secretid");
            return (Criteria) this;
        }

        public Criteria andCallNumIsNull() {
            addCriterion("sys_controll.CALL_NUM is null");
            return (Criteria) this;
        }

        public Criteria andCallNumIsNotNull() {
            addCriterion("sys_controll.CALL_NUM is not null");
            return (Criteria) this;
        }

        public Criteria andCallNumEqualTo(String value) {
            addCriterion("sys_controll.CALL_NUM =", value, "callNum");
            return (Criteria) this;
        }

        public Criteria andCallNumNotEqualTo(String value) {
            addCriterion("sys_controll.CALL_NUM <>", value, "callNum");
            return (Criteria) this;
        }

        public Criteria andCallNumGreaterThan(String value) {
            addCriterion("sys_controll.CALL_NUM >", value, "callNum");
            return (Criteria) this;
        }

        public Criteria andCallNumGreaterThanOrEqualTo(String value) {
            addCriterion("sys_controll.CALL_NUM >=", value, "callNum");
            return (Criteria) this;
        }

        public Criteria andCallNumLessThan(String value) {
            addCriterion("sys_controll.CALL_NUM <", value, "callNum");
            return (Criteria) this;
        }

        public Criteria andCallNumLessThanOrEqualTo(String value) {
            addCriterion("sys_controll.CALL_NUM <=", value, "callNum");
            return (Criteria) this;
        }

        public Criteria andCallNumLike(String value) {
            addCriterion("sys_controll.CALL_NUM like", value, "callNum");
            return (Criteria) this;
        }

        public Criteria andCallNumNotLike(String value) {
            addCriterion("sys_controll.CALL_NUM not like", value, "callNum");
            return (Criteria) this;
        }

        public Criteria andCallNumIn(List<String> values) {
            addCriterion("sys_controll.CALL_NUM in", values, "callNum");
            return (Criteria) this;
        }

        public Criteria andCallNumNotIn(List<String> values) {
            addCriterion("sys_controll.CALL_NUM not in", values, "callNum");
            return (Criteria) this;
        }

        public Criteria andCallNumBetween(String value1, String value2) {
            addCriterion("sys_controll.CALL_NUM between", value1, value2, "callNum");
            return (Criteria) this;
        }

        public Criteria andCallNumNotBetween(String value1, String value2) {
            addCriterion("sys_controll.CALL_NUM not between", value1, value2, "callNum");
            return (Criteria) this;
        }

        public Criteria andPermissionIsNull() {
            addCriterion("sys_controll.PERMISSION is null");
            return (Criteria) this;
        }

        public Criteria andPermissionIsNotNull() {
            addCriterion("sys_controll.PERMISSION is not null");
            return (Criteria) this;
        }

        public Criteria andPermissionEqualTo(Integer value) {
            addCriterion("sys_controll.PERMISSION =", value, "permission");
            return (Criteria) this;
        }

        public Criteria andPermissionNotEqualTo(Integer value) {
            addCriterion("sys_controll.PERMISSION <>", value, "permission");
            return (Criteria) this;
        }

        public Criteria andPermissionGreaterThan(Integer value) {
            addCriterion("sys_controll.PERMISSION >", value, "permission");
            return (Criteria) this;
        }

        public Criteria andPermissionGreaterThanOrEqualTo(Integer value) {
            addCriterion("sys_controll.PERMISSION >=", value, "permission");
            return (Criteria) this;
        }

        public Criteria andPermissionLessThan(Integer value) {
            addCriterion("sys_controll.PERMISSION <", value, "permission");
            return (Criteria) this;
        }

        public Criteria andPermissionLessThanOrEqualTo(Integer value) {
            addCriterion("sys_controll.PERMISSION <=", value, "permission");
            return (Criteria) this;
        }

        public Criteria andPermissionIn(List<Integer> values) {
            addCriterion("sys_controll.PERMISSION in", values, "permission");
            return (Criteria) this;
        }

        public Criteria andPermissionNotIn(List<Integer> values) {
            addCriterion("sys_controll.PERMISSION not in", values, "permission");
            return (Criteria) this;
        }

        public Criteria andPermissionBetween(Integer value1, Integer value2) {
            addCriterion("sys_controll.PERMISSION between", value1, value2, "permission");
            return (Criteria) this;
        }

        public Criteria andPermissionNotBetween(Integer value1, Integer value2) {
            addCriterion("sys_controll.PERMISSION not between", value1, value2, "permission");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("sys_controll.CREATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("sys_controll.CREATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("sys_controll.CREATE_TIME =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("sys_controll.CREATE_TIME <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("sys_controll.CREATE_TIME >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("sys_controll.CREATE_TIME >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("sys_controll.CREATE_TIME <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("sys_controll.CREATE_TIME <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("sys_controll.CREATE_TIME in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("sys_controll.CREATE_TIME not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("sys_controll.CREATE_TIME between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("sys_controll.CREATE_TIME not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("sys_controll.UPDATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("sys_controll.UPDATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("sys_controll.UPDATE_TIME =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("sys_controll.UPDATE_TIME <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("sys_controll.UPDATE_TIME >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("sys_controll.UPDATE_TIME >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("sys_controll.UPDATE_TIME <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("sys_controll.UPDATE_TIME <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("sys_controll.UPDATE_TIME in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("sys_controll.UPDATE_TIME not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("sys_controll.UPDATE_TIME between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("sys_controll.UPDATE_TIME not between", value1, value2, "updateTime");
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