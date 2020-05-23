package com.mzx.crud.bean;

import java.util.ArrayList;
import java.util.List;

public class MeetingRoomExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MeetingRoomExample() {
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

        public Criteria andMrIdIsNull() {
            addCriterion("mr_id is null");
            return (Criteria) this;
        }

        public Criteria andMrIdIsNotNull() {
            addCriterion("mr_id is not null");
            return (Criteria) this;
        }

        public Criteria andMrIdEqualTo(String value) {
            addCriterion("mr_id =", value, "mrId");
            return (Criteria) this;
        }

        public Criteria andMrIdNotEqualTo(String value) {
            addCriterion("mr_id <>", value, "mrId");
            return (Criteria) this;
        }

        public Criteria andMrIdGreaterThan(String value) {
            addCriterion("mr_id >", value, "mrId");
            return (Criteria) this;
        }

        public Criteria andMrIdGreaterThanOrEqualTo(String value) {
            addCriterion("mr_id >=", value, "mrId");
            return (Criteria) this;
        }

        public Criteria andMrIdLessThan(String value) {
            addCriterion("mr_id <", value, "mrId");
            return (Criteria) this;
        }

        public Criteria andMrIdLessThanOrEqualTo(String value) {
            addCriterion("mr_id <=", value, "mrId");
            return (Criteria) this;
        }

        public Criteria andMrIdLike(String value) {
            addCriterion("mr_id like", value, "mrId");
            return (Criteria) this;
        }

        public Criteria andMrIdNotLike(String value) {
            addCriterion("mr_id not like", value, "mrId");
            return (Criteria) this;
        }

        public Criteria andMrIdIn(List<String> values) {
            addCriterion("mr_id in", values, "mrId");
            return (Criteria) this;
        }

        public Criteria andMrIdNotIn(List<String> values) {
            addCriterion("mr_id not in", values, "mrId");
            return (Criteria) this;
        }

        public Criteria andMrIdBetween(String value1, String value2) {
            addCriterion("mr_id between", value1, value2, "mrId");
            return (Criteria) this;
        }

        public Criteria andMrIdNotBetween(String value1, String value2) {
            addCriterion("mr_id not between", value1, value2, "mrId");
            return (Criteria) this;
        }

        public Criteria andMrNameIsNull() {
            addCriterion("mr_name is null");
            return (Criteria) this;
        }

        public Criteria andMrNameIsNotNull() {
            addCriterion("mr_name is not null");
            return (Criteria) this;
        }

        public Criteria andMrNameEqualTo(String value) {
            addCriterion("mr_name =", value, "mrName");
            return (Criteria) this;
        }

        public Criteria andMrNameNotEqualTo(String value) {
            addCriterion("mr_name <>", value, "mrName");
            return (Criteria) this;
        }

        public Criteria andMrNameGreaterThan(String value) {
            addCriterion("mr_name >", value, "mrName");
            return (Criteria) this;
        }

        public Criteria andMrNameGreaterThanOrEqualTo(String value) {
            addCriterion("mr_name >=", value, "mrName");
            return (Criteria) this;
        }

        public Criteria andMrNameLessThan(String value) {
            addCriterion("mr_name <", value, "mrName");
            return (Criteria) this;
        }

        public Criteria andMrNameLessThanOrEqualTo(String value) {
            addCriterion("mr_name <=", value, "mrName");
            return (Criteria) this;
        }

        public Criteria andMrNameLike(String value) {
            addCriterion("mr_name like", value, "mrName");
            return (Criteria) this;
        }

        public Criteria andMrNameNotLike(String value) {
            addCriterion("mr_name not like", value, "mrName");
            return (Criteria) this;
        }

        public Criteria andMrNameIn(List<String> values) {
            addCriterion("mr_name in", values, "mrName");
            return (Criteria) this;
        }

        public Criteria andMrNameNotIn(List<String> values) {
            addCriterion("mr_name not in", values, "mrName");
            return (Criteria) this;
        }

        public Criteria andMrNameBetween(String value1, String value2) {
            addCriterion("mr_name between", value1, value2, "mrName");
            return (Criteria) this;
        }

        public Criteria andMrNameNotBetween(String value1, String value2) {
            addCriterion("mr_name not between", value1, value2, "mrName");
            return (Criteria) this;
        }

        public Criteria andMrTypeIsNull() {
            addCriterion("mr_type is null");
            return (Criteria) this;
        }

        public Criteria andMrTypeIsNotNull() {
            addCriterion("mr_type is not null");
            return (Criteria) this;
        }

        public Criteria andMrTypeEqualTo(String value) {
            addCriterion("mr_type =", value, "mrType");
            return (Criteria) this;
        }

        public Criteria andMrTypeNotEqualTo(String value) {
            addCriterion("mr_type <>", value, "mrType");
            return (Criteria) this;
        }

        public Criteria andMrTypeGreaterThan(String value) {
            addCriterion("mr_type >", value, "mrType");
            return (Criteria) this;
        }

        public Criteria andMrTypeGreaterThanOrEqualTo(String value) {
            addCriterion("mr_type >=", value, "mrType");
            return (Criteria) this;
        }

        public Criteria andMrTypeLessThan(String value) {
            addCriterion("mr_type <", value, "mrType");
            return (Criteria) this;
        }

        public Criteria andMrTypeLessThanOrEqualTo(String value) {
            addCriterion("mr_type <=", value, "mrType");
            return (Criteria) this;
        }

        public Criteria andMrTypeLike(String value) {
            addCriterion("mr_type like", value, "mrType");
            return (Criteria) this;
        }

        public Criteria andMrTypeNotLike(String value) {
            addCriterion("mr_type not like", value, "mrType");
            return (Criteria) this;
        }

        public Criteria andMrTypeIn(List<String> values) {
            addCriterion("mr_type in", values, "mrType");
            return (Criteria) this;
        }

        public Criteria andMrTypeNotIn(List<String> values) {
            addCriterion("mr_type not in", values, "mrType");
            return (Criteria) this;
        }

        public Criteria andMrTypeBetween(String value1, String value2) {
            addCriterion("mr_type between", value1, value2, "mrType");
            return (Criteria) this;
        }

        public Criteria andMrTypeNotBetween(String value1, String value2) {
            addCriterion("mr_type not between", value1, value2, "mrType");
            return (Criteria) this;
        }

        public Criteria andMrCapacityIsNull() {
            addCriterion("mr_capacity is null");
            return (Criteria) this;
        }

        public Criteria andMrCapacityIsNotNull() {
            addCriterion("mr_capacity is not null");
            return (Criteria) this;
        }

        public Criteria andMrCapacityEqualTo(Integer value) {
            addCriterion("mr_capacity =", value, "mrCapacity");
            return (Criteria) this;
        }

        public Criteria andMrCapacityNotEqualTo(Integer value) {
            addCriterion("mr_capacity <>", value, "mrCapacity");
            return (Criteria) this;
        }

        public Criteria andMrCapacityGreaterThan(Integer value) {
            addCriterion("mr_capacity >", value, "mrCapacity");
            return (Criteria) this;
        }

        public Criteria andMrCapacityGreaterThanOrEqualTo(Integer value) {
            addCriterion("mr_capacity >=", value, "mrCapacity");
            return (Criteria) this;
        }

        public Criteria andMrCapacityLessThan(Integer value) {
            addCriterion("mr_capacity <", value, "mrCapacity");
            return (Criteria) this;
        }

        public Criteria andMrCapacityLessThanOrEqualTo(Integer value) {
            addCriterion("mr_capacity <=", value, "mrCapacity");
            return (Criteria) this;
        }

        public Criteria andMrCapacityIn(List<Integer> values) {
            addCriterion("mr_capacity in", values, "mrCapacity");
            return (Criteria) this;
        }

        public Criteria andMrCapacityNotIn(List<Integer> values) {
            addCriterion("mr_capacity not in", values, "mrCapacity");
            return (Criteria) this;
        }

        public Criteria andMrCapacityBetween(Integer value1, Integer value2) {
            addCriterion("mr_capacity between", value1, value2, "mrCapacity");
            return (Criteria) this;
        }

        public Criteria andMrCapacityNotBetween(Integer value1, Integer value2) {
            addCriterion("mr_capacity not between", value1, value2, "mrCapacity");
            return (Criteria) this;
        }

        public Criteria andTblMeetingroomcolIsNull() {
            addCriterion("tbl_meetingroomcol is null");
            return (Criteria) this;
        }

        public Criteria andTblMeetingroomcolIsNotNull() {
            addCriterion("tbl_meetingroomcol is not null");
            return (Criteria) this;
        }

        public Criteria andTblMeetingroomcolEqualTo(String value) {
            addCriterion("tbl_meetingroomcol =", value, "tblMeetingroomcol");
            return (Criteria) this;
        }

        public Criteria andTblMeetingroomcolNotEqualTo(String value) {
            addCriterion("tbl_meetingroomcol <>", value, "tblMeetingroomcol");
            return (Criteria) this;
        }

        public Criteria andTblMeetingroomcolGreaterThan(String value) {
            addCriterion("tbl_meetingroomcol >", value, "tblMeetingroomcol");
            return (Criteria) this;
        }

        public Criteria andTblMeetingroomcolGreaterThanOrEqualTo(String value) {
            addCriterion("tbl_meetingroomcol >=", value, "tblMeetingroomcol");
            return (Criteria) this;
        }

        public Criteria andTblMeetingroomcolLessThan(String value) {
            addCriterion("tbl_meetingroomcol <", value, "tblMeetingroomcol");
            return (Criteria) this;
        }

        public Criteria andTblMeetingroomcolLessThanOrEqualTo(String value) {
            addCriterion("tbl_meetingroomcol <=", value, "tblMeetingroomcol");
            return (Criteria) this;
        }

        public Criteria andTblMeetingroomcolLike(String value) {
            addCriterion("tbl_meetingroomcol like", value, "tblMeetingroomcol");
            return (Criteria) this;
        }

        public Criteria andTblMeetingroomcolNotLike(String value) {
            addCriterion("tbl_meetingroomcol not like", value, "tblMeetingroomcol");
            return (Criteria) this;
        }

        public Criteria andTblMeetingroomcolIn(List<String> values) {
            addCriterion("tbl_meetingroomcol in", values, "tblMeetingroomcol");
            return (Criteria) this;
        }

        public Criteria andTblMeetingroomcolNotIn(List<String> values) {
            addCriterion("tbl_meetingroomcol not in", values, "tblMeetingroomcol");
            return (Criteria) this;
        }

        public Criteria andTblMeetingroomcolBetween(String value1, String value2) {
            addCriterion("tbl_meetingroomcol between", value1, value2, "tblMeetingroomcol");
            return (Criteria) this;
        }

        public Criteria andTblMeetingroomcolNotBetween(String value1, String value2) {
            addCriterion("tbl_meetingroomcol not between", value1, value2, "tblMeetingroomcol");
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