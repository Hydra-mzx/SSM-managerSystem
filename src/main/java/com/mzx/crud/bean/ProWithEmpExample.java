package com.mzx.crud.bean;

import java.util.ArrayList;
import java.util.List;

public class ProWithEmpExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ProWithEmpExample() {
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

        public Criteria andPweIdIsNull() {
            addCriterion("pwe_id is null");
            return (Criteria) this;
        }

        public Criteria andPweIdIsNotNull() {
            addCriterion("pwe_id is not null");
            return (Criteria) this;
        }

        public Criteria andPweIdEqualTo(Integer value) {
            addCriterion("pwe_id =", value, "pweId");
            return (Criteria) this;
        }

        public Criteria andPweIdNotEqualTo(Integer value) {
            addCriterion("pwe_id <>", value, "pweId");
            return (Criteria) this;
        }

        public Criteria andPweIdGreaterThan(Integer value) {
            addCriterion("pwe_id >", value, "pweId");
            return (Criteria) this;
        }

        public Criteria andPweIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("pwe_id >=", value, "pweId");
            return (Criteria) this;
        }

        public Criteria andPweIdLessThan(Integer value) {
            addCriterion("pwe_id <", value, "pweId");
            return (Criteria) this;
        }

        public Criteria andPweIdLessThanOrEqualTo(Integer value) {
            addCriterion("pwe_id <=", value, "pweId");
            return (Criteria) this;
        }

        public Criteria andPweIdIn(List<Integer> values) {
            addCriterion("pwe_id in", values, "pweId");
            return (Criteria) this;
        }

        public Criteria andPweIdNotIn(List<Integer> values) {
            addCriterion("pwe_id not in", values, "pweId");
            return (Criteria) this;
        }

        public Criteria andPweIdBetween(Integer value1, Integer value2) {
            addCriterion("pwe_id between", value1, value2, "pweId");
            return (Criteria) this;
        }

        public Criteria andPweIdNotBetween(Integer value1, Integer value2) {
            addCriterion("pwe_id not between", value1, value2, "pweId");
            return (Criteria) this;
        }

        public Criteria andPrIdIsNull() {
            addCriterion("pr_id is null");
            return (Criteria) this;
        }

        public Criteria andPrIdIsNotNull() {
            addCriterion("pr_id is not null");
            return (Criteria) this;
        }

        public Criteria andPrIdEqualTo(Integer value) {
            addCriterion("pr_id =", value, "prId");
            return (Criteria) this;
        }

        public Criteria andPrIdNotEqualTo(Integer value) {
            addCriterion("pr_id <>", value, "prId");
            return (Criteria) this;
        }

        public Criteria andPrIdGreaterThan(Integer value) {
            addCriterion("pr_id >", value, "prId");
            return (Criteria) this;
        }

        public Criteria andPrIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("pr_id >=", value, "prId");
            return (Criteria) this;
        }

        public Criteria andPrIdLessThan(Integer value) {
            addCriterion("pr_id <", value, "prId");
            return (Criteria) this;
        }

        public Criteria andPrIdLessThanOrEqualTo(Integer value) {
            addCriterion("pr_id <=", value, "prId");
            return (Criteria) this;
        }

        public Criteria andPrIdIn(List<Integer> values) {
            addCriterion("pr_id in", values, "prId");
            return (Criteria) this;
        }

        public Criteria andPrIdNotIn(List<Integer> values) {
            addCriterion("pr_id not in", values, "prId");
            return (Criteria) this;
        }

        public Criteria andPrIdBetween(Integer value1, Integer value2) {
            addCriterion("pr_id between", value1, value2, "prId");
            return (Criteria) this;
        }

        public Criteria andPrIdNotBetween(Integer value1, Integer value2) {
            addCriterion("pr_id not between", value1, value2, "prId");
            return (Criteria) this;
        }

        public Criteria andEmIdIsNull() {
            addCriterion("em_id is null");
            return (Criteria) this;
        }

        public Criteria andEmIdIsNotNull() {
            addCriterion("em_id is not null");
            return (Criteria) this;
        }

        public Criteria andEmIdEqualTo(Integer value) {
            addCriterion("em_id =", value, "emId");
            return (Criteria) this;
        }

        public Criteria andEmIdNotEqualTo(Integer value) {
            addCriterion("em_id <>", value, "emId");
            return (Criteria) this;
        }

        public Criteria andEmIdGreaterThan(Integer value) {
            addCriterion("em_id >", value, "emId");
            return (Criteria) this;
        }

        public Criteria andEmIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("em_id >=", value, "emId");
            return (Criteria) this;
        }

        public Criteria andEmIdLessThan(Integer value) {
            addCriterion("em_id <", value, "emId");
            return (Criteria) this;
        }

        public Criteria andEmIdLessThanOrEqualTo(Integer value) {
            addCriterion("em_id <=", value, "emId");
            return (Criteria) this;
        }

        public Criteria andEmIdIn(List<Integer> values) {
            addCriterion("em_id in", values, "emId");
            return (Criteria) this;
        }

        public Criteria andEmIdNotIn(List<Integer> values) {
            addCriterion("em_id not in", values, "emId");
            return (Criteria) this;
        }

        public Criteria andEmIdBetween(Integer value1, Integer value2) {
            addCriterion("em_id between", value1, value2, "emId");
            return (Criteria) this;
        }

        public Criteria andEmIdNotBetween(Integer value1, Integer value2) {
            addCriterion("em_id not between", value1, value2, "emId");
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