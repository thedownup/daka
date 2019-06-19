package com.daka.webserver.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SysClockExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Long offset;

    public SysClockExample() {
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

        public Criteria andClockTimeIsNull() {
            addCriterion("CLOCK_TIME is null");
            return (Criteria) this;
        }

        public Criteria andClockTimeIsNotNull() {
            addCriterion("CLOCK_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andClockTimeEqualTo(Date value) {
            addCriterion("CLOCK_TIME =", value, "clockTime");
            return (Criteria) this;
        }

        public Criteria andClockTimeNotEqualTo(Date value) {
            addCriterion("CLOCK_TIME <>", value, "clockTime");
            return (Criteria) this;
        }

        public Criteria andClockTimeGreaterThan(Date value) {
            addCriterion("CLOCK_TIME >", value, "clockTime");
            return (Criteria) this;
        }

        public Criteria andClockTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("CLOCK_TIME >=", value, "clockTime");
            return (Criteria) this;
        }

        public Criteria andClockTimeLessThan(Date value) {
            addCriterion("CLOCK_TIME <", value, "clockTime");
            return (Criteria) this;
        }

        public Criteria andClockTimeLessThanOrEqualTo(Date value) {
            addCriterion("CLOCK_TIME <=", value, "clockTime");
            return (Criteria) this;
        }

        public Criteria andClockTimeIn(List<Date> values) {
            addCriterion("CLOCK_TIME in", values, "clockTime");
            return (Criteria) this;
        }

        public Criteria andClockTimeNotIn(List<Date> values) {
            addCriterion("CLOCK_TIME not in", values, "clockTime");
            return (Criteria) this;
        }

        public Criteria andClockTimeBetween(Date value1, Date value2) {
            addCriterion("CLOCK_TIME between", value1, value2, "clockTime");
            return (Criteria) this;
        }

        public Criteria andClockTimeNotBetween(Date value1, Date value2) {
            addCriterion("CLOCK_TIME not between", value1, value2, "clockTime");
            return (Criteria) this;
        }

        public Criteria andLateIsNull() {
            addCriterion("LATE is null");
            return (Criteria) this;
        }

        public Criteria andLateIsNotNull() {
            addCriterion("LATE is not null");
            return (Criteria) this;
        }

        public Criteria andLateEqualTo(Integer value) {
            addCriterion("LATE =", value, "late");
            return (Criteria) this;
        }

        public Criteria andLateNotEqualTo(Integer value) {
            addCriterion("LATE <>", value, "late");
            return (Criteria) this;
        }

        public Criteria andLateGreaterThan(Integer value) {
            addCriterion("LATE >", value, "late");
            return (Criteria) this;
        }

        public Criteria andLateGreaterThanOrEqualTo(Integer value) {
            addCriterion("LATE >=", value, "late");
            return (Criteria) this;
        }

        public Criteria andLateLessThan(Integer value) {
            addCriterion("LATE <", value, "late");
            return (Criteria) this;
        }

        public Criteria andLateLessThanOrEqualTo(Integer value) {
            addCriterion("LATE <=", value, "late");
            return (Criteria) this;
        }

        public Criteria andLateIn(List<Integer> values) {
            addCriterion("LATE in", values, "late");
            return (Criteria) this;
        }

        public Criteria andLateNotIn(List<Integer> values) {
            addCriterion("LATE not in", values, "late");
            return (Criteria) this;
        }

        public Criteria andLateBetween(Integer value1, Integer value2) {
            addCriterion("LATE between", value1, value2, "late");
            return (Criteria) this;
        }

        public Criteria andLateNotBetween(Integer value1, Integer value2) {
            addCriterion("LATE not between", value1, value2, "late");
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