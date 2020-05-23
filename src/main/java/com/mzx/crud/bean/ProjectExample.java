package com.mzx.crud.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class ProjectExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ProjectExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andProIdIsNull() {
            addCriterion("pro_id is null");
            return (Criteria) this;
        }

        public Criteria andProIdIsNotNull() {
            addCriterion("pro_id is not null");
            return (Criteria) this;
        }

        public Criteria andProIdEqualTo(Integer value) {
            addCriterion("pro_id =", value, "proId");
            return (Criteria) this;
        }

        public Criteria andProIdNotEqualTo(Integer value) {
            addCriterion("pro_id <>", value, "proId");
            return (Criteria) this;
        }

        public Criteria andProIdGreaterThan(Integer value) {
            addCriterion("pro_id >", value, "proId");
            return (Criteria) this;
        }

        public Criteria andProIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("pro_id >=", value, "proId");
            return (Criteria) this;
        }

        public Criteria andProIdLessThan(Integer value) {
            addCriterion("pro_id <", value, "proId");
            return (Criteria) this;
        }

        public Criteria andProIdLessThanOrEqualTo(Integer value) {
            addCriterion("pro_id <=", value, "proId");
            return (Criteria) this;
        }

        public Criteria andProIdIn(List<Integer> values) {
            addCriterion("pro_id in", values, "proId");
            return (Criteria) this;
        }

        public Criteria andProIdNotIn(List<Integer> values) {
            addCriterion("pro_id not in", values, "proId");
            return (Criteria) this;
        }

        public Criteria andProIdBetween(Integer value1, Integer value2) {
            addCriterion("pro_id between", value1, value2, "proId");
            return (Criteria) this;
        }

        public Criteria andProIdNotBetween(Integer value1, Integer value2) {
            addCriterion("pro_id not between", value1, value2, "proId");
            return (Criteria) this;
        }

        public Criteria andProNameIsNull() {
            addCriterion("pro_name is null");
            return (Criteria) this;
        }

        public Criteria andProNameIsNotNull() {
            addCriterion("pro_name is not null");
            return (Criteria) this;
        }

        public Criteria andProNameEqualTo(String value) {
            addCriterion("pro_name =", value, "proName");
            return (Criteria) this;
        }

        public Criteria andProNameNotEqualTo(String value) {
            addCriterion("pro_name <>", value, "proName");
            return (Criteria) this;
        }

        public Criteria andProNameGreaterThan(String value) {
            addCriterion("pro_name >", value, "proName");
            return (Criteria) this;
        }

        public Criteria andProNameGreaterThanOrEqualTo(String value) {
            addCriterion("pro_name >=", value, "proName");
            return (Criteria) this;
        }

        public Criteria andProNameLessThan(String value) {
            addCriterion("pro_name <", value, "proName");
            return (Criteria) this;
        }

        public Criteria andProNameLessThanOrEqualTo(String value) {
            addCriterion("pro_name <=", value, "proName");
            return (Criteria) this;
        }

        public Criteria andProNameLike(String value) {
            addCriterion("pro_name like", value, "proName");
            return (Criteria) this;
        }

        public Criteria andProNameNotLike(String value) {
            addCriterion("pro_name not like", value, "proName");
            return (Criteria) this;
        }

        public Criteria andProNameIn(List<String> values) {
            addCriterion("pro_name in", values, "proName");
            return (Criteria) this;
        }

        public Criteria andProNameNotIn(List<String> values) {
            addCriterion("pro_name not in", values, "proName");
            return (Criteria) this;
        }

        public Criteria andProNameBetween(String value1, String value2) {
            addCriterion("pro_name between", value1, value2, "proName");
            return (Criteria) this;
        }

        public Criteria andProNameNotBetween(String value1, String value2) {
            addCriterion("pro_name not between", value1, value2, "proName");
            return (Criteria) this;
        }

        public Criteria andProTimeIsNull() {
            addCriterion("pro_time is null");
            return (Criteria) this;
        }

        public Criteria andProTimeIsNotNull() {
            addCriterion("pro_time is not null");
            return (Criteria) this;
        }

        public Criteria andProTimeEqualTo(Date value) {
            addCriterionForJDBCDate("pro_time =", value, "proTime");
            return (Criteria) this;
        }

        public Criteria andProTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("pro_time <>", value, "proTime");
            return (Criteria) this;
        }

        public Criteria andProTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("pro_time >", value, "proTime");
            return (Criteria) this;
        }

        public Criteria andProTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("pro_time >=", value, "proTime");
            return (Criteria) this;
        }

        public Criteria andProTimeLessThan(Date value) {
            addCriterionForJDBCDate("pro_time <", value, "proTime");
            return (Criteria) this;
        }

        public Criteria andProTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("pro_time <=", value, "proTime");
            return (Criteria) this;
        }

        public Criteria andProTimeIn(List<Date> values) {
            addCriterionForJDBCDate("pro_time in", values, "proTime");
            return (Criteria) this;
        }

        public Criteria andProTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("pro_time not in", values, "proTime");
            return (Criteria) this;
        }

        public Criteria andProTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("pro_time between", value1, value2, "proTime");
            return (Criteria) this;
        }

        public Criteria andProTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("pro_time not between", value1, value2, "proTime");
            return (Criteria) this;
        }

        public Criteria andProStateIsNull() {
            addCriterion("pro_state is null");
            return (Criteria) this;
        }

        public Criteria andProStateIsNotNull() {
            addCriterion("pro_state is not null");
            return (Criteria) this;
        }

        public Criteria andProStateEqualTo(Integer value) {
            addCriterion("pro_state =", value, "proState");
            return (Criteria) this;
        }

        public Criteria andProStateNotEqualTo(Integer value) {
            addCriterion("pro_state <>", value, "proState");
            return (Criteria) this;
        }

        public Criteria andProStateGreaterThan(Integer value) {
            addCriterion("pro_state >", value, "proState");
            return (Criteria) this;
        }

        public Criteria andProStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("pro_state >=", value, "proState");
            return (Criteria) this;
        }

        public Criteria andProStateLessThan(Integer value) {
            addCriterion("pro_state <", value, "proState");
            return (Criteria) this;
        }

        public Criteria andProStateLessThanOrEqualTo(Integer value) {
            addCriterion("pro_state <=", value, "proState");
            return (Criteria) this;
        }

        public Criteria andProStateIn(List<Integer> values) {
            addCriterion("pro_state in", values, "proState");
            return (Criteria) this;
        }

        public Criteria andProStateNotIn(List<Integer> values) {
            addCriterion("pro_state not in", values, "proState");
            return (Criteria) this;
        }

        public Criteria andProStateBetween(Integer value1, Integer value2) {
            addCriterion("pro_state between", value1, value2, "proState");
            return (Criteria) this;
        }

        public Criteria andProStateNotBetween(Integer value1, Integer value2) {
            addCriterion("pro_state not between", value1, value2, "proState");
            return (Criteria) this;
        }

        public Criteria andProDeptIsNull() {
            addCriterion("pro_dept is null");
            return (Criteria) this;
        }

        public Criteria andProDeptIsNotNull() {
            addCriterion("pro_dept is not null");
            return (Criteria) this;
        }

        public Criteria andProDeptEqualTo(Integer value) {
            addCriterion("pro_dept =", value, "proDept");
            return (Criteria) this;
        }

        public Criteria andProDeptNotEqualTo(Integer value) {
            addCriterion("pro_dept <>", value, "proDept");
            return (Criteria) this;
        }

        public Criteria andProDeptGreaterThan(Integer value) {
            addCriterion("pro_dept >", value, "proDept");
            return (Criteria) this;
        }

        public Criteria andProDeptGreaterThanOrEqualTo(Integer value) {
            addCriterion("pro_dept >=", value, "proDept");
            return (Criteria) this;
        }

        public Criteria andProDeptLessThan(Integer value) {
            addCriterion("pro_dept <", value, "proDept");
            return (Criteria) this;
        }

        public Criteria andProDeptLessThanOrEqualTo(Integer value) {
            addCriterion("pro_dept <=", value, "proDept");
            return (Criteria) this;
        }

        public Criteria andProDeptIn(List<Integer> values) {
            addCriterion("pro_dept in", values, "proDept");
            return (Criteria) this;
        }

        public Criteria andProDeptNotIn(List<Integer> values) {
            addCriterion("pro_dept not in", values, "proDept");
            return (Criteria) this;
        }

        public Criteria andProDeptBetween(Integer value1, Integer value2) {
            addCriterion("pro_dept between", value1, value2, "proDept");
            return (Criteria) this;
        }

        public Criteria andProDeptNotBetween(Integer value1, Integer value2) {
            addCriterion("pro_dept not between", value1, value2, "proDept");
            return (Criteria) this;
        }

        public Criteria andProTypeIsNull() {
            addCriterion("pro_type is null");
            return (Criteria) this;
        }

        public Criteria andProTypeIsNotNull() {
            addCriterion("pro_type is not null");
            return (Criteria) this;
        }

        public Criteria andProTypeEqualTo(String value) {
            addCriterion("pro_type =", value, "proType");
            return (Criteria) this;
        }

        public Criteria andProTypeNotEqualTo(String value) {
            addCriterion("pro_type <>", value, "proType");
            return (Criteria) this;
        }

        public Criteria andProTypeGreaterThan(String value) {
            addCriterion("pro_type >", value, "proType");
            return (Criteria) this;
        }

        public Criteria andProTypeGreaterThanOrEqualTo(String value) {
            addCriterion("pro_type >=", value, "proType");
            return (Criteria) this;
        }

        public Criteria andProTypeLessThan(String value) {
            addCriterion("pro_type <", value, "proType");
            return (Criteria) this;
        }

        public Criteria andProTypeLessThanOrEqualTo(String value) {
            addCriterion("pro_type <=", value, "proType");
            return (Criteria) this;
        }

        public Criteria andProTypeLike(String value) {
            addCriterion("pro_type like", value, "proType");
            return (Criteria) this;
        }

        public Criteria andProTypeNotLike(String value) {
            addCriterion("pro_type not like", value, "proType");
            return (Criteria) this;
        }

        public Criteria andProTypeIn(List<String> values) {
            addCriterion("pro_type in", values, "proType");
            return (Criteria) this;
        }

        public Criteria andProTypeNotIn(List<String> values) {
            addCriterion("pro_type not in", values, "proType");
            return (Criteria) this;
        }

        public Criteria andProTypeBetween(String value1, String value2) {
            addCriterion("pro_type between", value1, value2, "proType");
            return (Criteria) this;
        }

        public Criteria andProTypeNotBetween(String value1, String value2) {
            addCriterion("pro_type not between", value1, value2, "proType");
            return (Criteria) this;
        }

        public Criteria andProEmpsIsNull() {
            addCriterion("pro_emps is null");
            return (Criteria) this;
        }

        public Criteria andProEmpsIsNotNull() {
            addCriterion("pro_emps is not null");
            return (Criteria) this;
        }

        public Criteria andProEmpsEqualTo(String value) {
            addCriterion("pro_emps =", value, "proEmps");
            return (Criteria) this;
        }

        public Criteria andProEmpsNotEqualTo(String value) {
            addCriterion("pro_emps <>", value, "proEmps");
            return (Criteria) this;
        }

        public Criteria andProEmpsGreaterThan(String value) {
            addCriterion("pro_emps >", value, "proEmps");
            return (Criteria) this;
        }

        public Criteria andProEmpsGreaterThanOrEqualTo(String value) {
            addCriterion("pro_emps >=", value, "proEmps");
            return (Criteria) this;
        }

        public Criteria andProEmpsLessThan(String value) {
            addCriterion("pro_emps <", value, "proEmps");
            return (Criteria) this;
        }

        public Criteria andProEmpsLessThanOrEqualTo(String value) {
            addCriterion("pro_emps <=", value, "proEmps");
            return (Criteria) this;
        }

        public Criteria andProEmpsLike(String value) {
            addCriterion("pro_emps like", value, "proEmps");
            return (Criteria) this;
        }

        public Criteria andProEmpsNotLike(String value) {
            addCriterion("pro_emps not like", value, "proEmps");
            return (Criteria) this;
        }

        public Criteria andProEmpsIn(List<String> values) {
            addCriterion("pro_emps in", values, "proEmps");
            return (Criteria) this;
        }

        public Criteria andProEmpsNotIn(List<String> values) {
            addCriterion("pro_emps not in", values, "proEmps");
            return (Criteria) this;
        }

        public Criteria andProEmpsBetween(String value1, String value2) {
            addCriterion("pro_emps between", value1, value2, "proEmps");
            return (Criteria) this;
        }

        public Criteria andProEmpsNotBetween(String value1, String value2) {
            addCriterion("pro_emps not between", value1, value2, "proEmps");
            return (Criteria) this;
        }
    }

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