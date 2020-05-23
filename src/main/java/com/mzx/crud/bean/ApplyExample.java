package com.mzx.crud.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ApplyExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ApplyExample() {
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

        public Criteria andApplyIdIsNull() {
            addCriterion("apply_id is null");
            return (Criteria) this;
        }

        public Criteria andApplyIdIsNotNull() {
            addCriterion("apply_id is not null");
            return (Criteria) this;
        }

        public Criteria andApplyIdEqualTo(Integer value) {
            addCriterion("apply_id =", value, "applyId");
            return (Criteria) this;
        }

        public Criteria andApplyIdNotEqualTo(Integer value) {
            addCriterion("apply_id <>", value, "applyId");
            return (Criteria) this;
        }

        public Criteria andApplyIdGreaterThan(Integer value) {
            addCriterion("apply_id >", value, "applyId");
            return (Criteria) this;
        }

        public Criteria andApplyIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("apply_id >=", value, "applyId");
            return (Criteria) this;
        }

        public Criteria andApplyIdLessThan(Integer value) {
            addCriterion("apply_id <", value, "applyId");
            return (Criteria) this;
        }

        public Criteria andApplyIdLessThanOrEqualTo(Integer value) {
            addCriterion("apply_id <=", value, "applyId");
            return (Criteria) this;
        }

        public Criteria andApplyIdIn(List<Integer> values) {
            addCriterion("apply_id in", values, "applyId");
            return (Criteria) this;
        }

        public Criteria andApplyIdNotIn(List<Integer> values) {
            addCriterion("apply_id not in", values, "applyId");
            return (Criteria) this;
        }

        public Criteria andApplyIdBetween(Integer value1, Integer value2) {
            addCriterion("apply_id between", value1, value2, "applyId");
            return (Criteria) this;
        }

        public Criteria andApplyIdNotBetween(Integer value1, Integer value2) {
            addCriterion("apply_id not between", value1, value2, "applyId");
            return (Criteria) this;
        }

        public Criteria andApplyTimeStartIsNull() {
            addCriterion("apply_time_start is null");
            return (Criteria) this;
        }

        public Criteria andApplyTimeStartIsNotNull() {
            addCriterion("apply_time_start is not null");
            return (Criteria) this;
        }

        public Criteria andApplyTimeStartEqualTo(Date value) {
            addCriterion("apply_time_start =", value, "applyTimeStart");
            return (Criteria) this;
        }

        public Criteria andApplyTimeStartNotEqualTo(Date value) {
            addCriterion("apply_time_start <>", value, "applyTimeStart");
            return (Criteria) this;
        }

        public Criteria andApplyTimeStartGreaterThan(Date value) {
            addCriterion("apply_time_start >", value, "applyTimeStart");
            return (Criteria) this;
        }

        public Criteria andApplyTimeStartGreaterThanOrEqualTo(Date value) {
            addCriterion("apply_time_start >=", value, "applyTimeStart");
            return (Criteria) this;
        }

        public Criteria andApplyTimeStartLessThan(Date value) {
            addCriterion("apply_time_start <", value, "applyTimeStart");
            return (Criteria) this;
        }

        public Criteria andApplyTimeStartLessThanOrEqualTo(Date value) {
            addCriterion("apply_time_start <=", value, "applyTimeStart");
            return (Criteria) this;
        }

        public Criteria andApplyTimeStartIn(List<Date> values) {
            addCriterion("apply_time_start in", values, "applyTimeStart");
            return (Criteria) this;
        }

        public Criteria andApplyTimeStartNotIn(List<Date> values) {
            addCriterion("apply_time_start not in", values, "applyTimeStart");
            return (Criteria) this;
        }

        public Criteria andApplyTimeStartBetween(Date value1, Date value2) {
            addCriterion("apply_time_start between", value1, value2, "applyTimeStart");
            return (Criteria) this;
        }

        public Criteria andApplyTimeStartNotBetween(Date value1, Date value2) {
            addCriterion("apply_time_start not between", value1, value2, "applyTimeStart");
            return (Criteria) this;
        }

        public Criteria andApplyTimeEndIsNull() {
            addCriterion("apply_time_end is null");
            return (Criteria) this;
        }

        public Criteria andApplyTimeEndIsNotNull() {
            addCriterion("apply_time_end is not null");
            return (Criteria) this;
        }

        public Criteria andApplyTimeEndEqualTo(Date value) {
            addCriterion("apply_time_end =", value, "applyTimeEnd");
            return (Criteria) this;
        }

        public Criteria andApplyTimeEndNotEqualTo(Date value) {
            addCriterion("apply_time_end <>", value, "applyTimeEnd");
            return (Criteria) this;
        }

        public Criteria andApplyTimeEndGreaterThan(Date value) {
            addCriterion("apply_time_end >", value, "applyTimeEnd");
            return (Criteria) this;
        }

        public Criteria andApplyTimeEndGreaterThanOrEqualTo(Date value) {
            addCriterion("apply_time_end >=", value, "applyTimeEnd");
            return (Criteria) this;
        }

        public Criteria andApplyTimeEndLessThan(Date value) {
            addCriterion("apply_time_end <", value, "applyTimeEnd");
            return (Criteria) this;
        }

        public Criteria andApplyTimeEndLessThanOrEqualTo(Date value) {
            addCriterion("apply_time_end <=", value, "applyTimeEnd");
            return (Criteria) this;
        }

        public Criteria andApplyTimeEndIn(List<Date> values) {
            addCriterion("apply_time_end in", values, "applyTimeEnd");
            return (Criteria) this;
        }

        public Criteria andApplyTimeEndNotIn(List<Date> values) {
            addCriterion("apply_time_end not in", values, "applyTimeEnd");
            return (Criteria) this;
        }

        public Criteria andApplyTimeEndBetween(Date value1, Date value2) {
            addCriterion("apply_time_end between", value1, value2, "applyTimeEnd");
            return (Criteria) this;
        }

        public Criteria andApplyTimeEndNotBetween(Date value1, Date value2) {
            addCriterion("apply_time_end not between", value1, value2, "applyTimeEnd");
            return (Criteria) this;
        }

        public Criteria andApplyEmpIsNull() {
            addCriterion("apply_emp is null");
            return (Criteria) this;
        }

        public Criteria andApplyEmpIsNotNull() {
            addCriterion("apply_emp is not null");
            return (Criteria) this;
        }

        public Criteria andApplyEmpEqualTo(String value) {
            addCriterion("apply_emp =", value, "applyEmp");
            return (Criteria) this;
        }

        public Criteria andApplyEmpNotEqualTo(String value) {
            addCriterion("apply_emp <>", value, "applyEmp");
            return (Criteria) this;
        }

        public Criteria andApplyEmpGreaterThan(String value) {
            addCriterion("apply_emp >", value, "applyEmp");
            return (Criteria) this;
        }

        public Criteria andApplyEmpGreaterThanOrEqualTo(String value) {
            addCriterion("apply_emp >=", value, "applyEmp");
            return (Criteria) this;
        }

        public Criteria andApplyEmpLessThan(String value) {
            addCriterion("apply_emp <", value, "applyEmp");
            return (Criteria) this;
        }

        public Criteria andApplyEmpLessThanOrEqualTo(String value) {
            addCriterion("apply_emp <=", value, "applyEmp");
            return (Criteria) this;
        }

        public Criteria andApplyEmpLike(String value) {
            addCriterion("apply_emp like", value, "applyEmp");
            return (Criteria) this;
        }

        public Criteria andApplyEmpNotLike(String value) {
            addCriterion("apply_emp not like", value, "applyEmp");
            return (Criteria) this;
        }

        public Criteria andApplyEmpIn(List<String> values) {
            addCriterion("apply_emp in", values, "applyEmp");
            return (Criteria) this;
        }

        public Criteria andApplyEmpNotIn(List<String> values) {
            addCriterion("apply_emp not in", values, "applyEmp");
            return (Criteria) this;
        }

        public Criteria andApplyEmpBetween(String value1, String value2) {
            addCriterion("apply_emp between", value1, value2, "applyEmp");
            return (Criteria) this;
        }

        public Criteria andApplyEmpNotBetween(String value1, String value2) {
            addCriterion("apply_emp not between", value1, value2, "applyEmp");
            return (Criteria) this;
        }

        public Criteria andApplyDeptIsNull() {
            addCriterion("apply_dept is null");
            return (Criteria) this;
        }

        public Criteria andApplyDeptIsNotNull() {
            addCriterion("apply_dept is not null");
            return (Criteria) this;
        }

        public Criteria andApplyDeptEqualTo(Integer value) {
            addCriterion("apply_dept =", value, "applyDept");
            return (Criteria) this;
        }

        public Criteria andApplyDeptNotEqualTo(Integer value) {
            addCriterion("apply_dept <>", value, "applyDept");
            return (Criteria) this;
        }

        public Criteria andApplyDeptGreaterThan(Integer value) {
            addCriterion("apply_dept >", value, "applyDept");
            return (Criteria) this;
        }

        public Criteria andApplyDeptGreaterThanOrEqualTo(Integer value) {
            addCriterion("apply_dept >=", value, "applyDept");
            return (Criteria) this;
        }

        public Criteria andApplyDeptLessThan(Integer value) {
            addCriterion("apply_dept <", value, "applyDept");
            return (Criteria) this;
        }

        public Criteria andApplyDeptLessThanOrEqualTo(Integer value) {
            addCriterion("apply_dept <=", value, "applyDept");
            return (Criteria) this;
        }

        public Criteria andApplyDeptIn(List<Integer> values) {
            addCriterion("apply_dept in", values, "applyDept");
            return (Criteria) this;
        }

        public Criteria andApplyDeptNotIn(List<Integer> values) {
            addCriterion("apply_dept not in", values, "applyDept");
            return (Criteria) this;
        }

        public Criteria andApplyDeptBetween(Integer value1, Integer value2) {
            addCriterion("apply_dept between", value1, value2, "applyDept");
            return (Criteria) this;
        }

        public Criteria andApplyDeptNotBetween(Integer value1, Integer value2) {
            addCriterion("apply_dept not between", value1, value2, "applyDept");
            return (Criteria) this;
        }

        public Criteria andApplyCapacityIsNull() {
            addCriterion("apply_capacity is null");
            return (Criteria) this;
        }

        public Criteria andApplyCapacityIsNotNull() {
            addCriterion("apply_capacity is not null");
            return (Criteria) this;
        }

        public Criteria andApplyCapacityEqualTo(Integer value) {
            addCriterion("apply_capacity =", value, "applyCapacity");
            return (Criteria) this;
        }

        public Criteria andApplyCapacityNotEqualTo(Integer value) {
            addCriterion("apply_capacity <>", value, "applyCapacity");
            return (Criteria) this;
        }

        public Criteria andApplyCapacityGreaterThan(Integer value) {
            addCriterion("apply_capacity >", value, "applyCapacity");
            return (Criteria) this;
        }

        public Criteria andApplyCapacityGreaterThanOrEqualTo(Integer value) {
            addCriterion("apply_capacity >=", value, "applyCapacity");
            return (Criteria) this;
        }

        public Criteria andApplyCapacityLessThan(Integer value) {
            addCriterion("apply_capacity <", value, "applyCapacity");
            return (Criteria) this;
        }

        public Criteria andApplyCapacityLessThanOrEqualTo(Integer value) {
            addCriterion("apply_capacity <=", value, "applyCapacity");
            return (Criteria) this;
        }

        public Criteria andApplyCapacityIn(List<Integer> values) {
            addCriterion("apply_capacity in", values, "applyCapacity");
            return (Criteria) this;
        }

        public Criteria andApplyCapacityNotIn(List<Integer> values) {
            addCriterion("apply_capacity not in", values, "applyCapacity");
            return (Criteria) this;
        }

        public Criteria andApplyCapacityBetween(Integer value1, Integer value2) {
            addCriterion("apply_capacity between", value1, value2, "applyCapacity");
            return (Criteria) this;
        }

        public Criteria andApplyCapacityNotBetween(Integer value1, Integer value2) {
            addCriterion("apply_capacity not between", value1, value2, "applyCapacity");
            return (Criteria) this;
        }

        public Criteria andApplyRemarkIsNull() {
            addCriterion("apply_remark is null");
            return (Criteria) this;
        }

        public Criteria andApplyRemarkIsNotNull() {
            addCriterion("apply_remark is not null");
            return (Criteria) this;
        }

        public Criteria andApplyRemarkEqualTo(String value) {
            addCriterion("apply_remark =", value, "applyRemark");
            return (Criteria) this;
        }

        public Criteria andApplyRemarkNotEqualTo(String value) {
            addCriterion("apply_remark <>", value, "applyRemark");
            return (Criteria) this;
        }

        public Criteria andApplyRemarkGreaterThan(String value) {
            addCriterion("apply_remark >", value, "applyRemark");
            return (Criteria) this;
        }

        public Criteria andApplyRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("apply_remark >=", value, "applyRemark");
            return (Criteria) this;
        }

        public Criteria andApplyRemarkLessThan(String value) {
            addCriterion("apply_remark <", value, "applyRemark");
            return (Criteria) this;
        }

        public Criteria andApplyRemarkLessThanOrEqualTo(String value) {
            addCriterion("apply_remark <=", value, "applyRemark");
            return (Criteria) this;
        }

        public Criteria andApplyRemarkLike(String value) {
            addCriterion("apply_remark like", value, "applyRemark");
            return (Criteria) this;
        }

        public Criteria andApplyRemarkNotLike(String value) {
            addCriterion("apply_remark not like", value, "applyRemark");
            return (Criteria) this;
        }

        public Criteria andApplyRemarkIn(List<String> values) {
            addCriterion("apply_remark in", values, "applyRemark");
            return (Criteria) this;
        }

        public Criteria andApplyRemarkNotIn(List<String> values) {
            addCriterion("apply_remark not in", values, "applyRemark");
            return (Criteria) this;
        }

        public Criteria andApplyRemarkBetween(String value1, String value2) {
            addCriterion("apply_remark between", value1, value2, "applyRemark");
            return (Criteria) this;
        }

        public Criteria andApplyRemarkNotBetween(String value1, String value2) {
            addCriterion("apply_remark not between", value1, value2, "applyRemark");
            return (Criteria) this;
        }

        public Criteria andApplyMrIsNull() {
            addCriterion("apply_mr is null");
            return (Criteria) this;
        }

        public Criteria andApplyMrIsNotNull() {
            addCriterion("apply_mr is not null");
            return (Criteria) this;
        }

        public Criteria andApplyMrEqualTo(String value) {
            addCriterion("apply_mr =", value, "applyMr");
            return (Criteria) this;
        }

        public Criteria andApplyMrNotEqualTo(String value) {
            addCriterion("apply_mr <>", value, "applyMr");
            return (Criteria) this;
        }

        public Criteria andApplyMrGreaterThan(String value) {
            addCriterion("apply_mr >", value, "applyMr");
            return (Criteria) this;
        }

        public Criteria andApplyMrGreaterThanOrEqualTo(String value) {
            addCriterion("apply_mr >=", value, "applyMr");
            return (Criteria) this;
        }

        public Criteria andApplyMrLessThan(String value) {
            addCriterion("apply_mr <", value, "applyMr");
            return (Criteria) this;
        }

        public Criteria andApplyMrLessThanOrEqualTo(String value) {
            addCriterion("apply_mr <=", value, "applyMr");
            return (Criteria) this;
        }

        public Criteria andApplyMrLike(String value) {
            addCriterion("apply_mr like", value, "applyMr");
            return (Criteria) this;
        }

        public Criteria andApplyMrNotLike(String value) {
            addCriterion("apply_mr not like", value, "applyMr");
            return (Criteria) this;
        }

        public Criteria andApplyMrIn(List<String> values) {
            addCriterion("apply_mr in", values, "applyMr");
            return (Criteria) this;
        }

        public Criteria andApplyMrNotIn(List<String> values) {
            addCriterion("apply_mr not in", values, "applyMr");
            return (Criteria) this;
        }

        public Criteria andApplyMrBetween(String value1, String value2) {
            addCriterion("apply_mr between", value1, value2, "applyMr");
            return (Criteria) this;
        }

        public Criteria andApplyMrNotBetween(String value1, String value2) {
            addCriterion("apply_mr not between", value1, value2, "applyMr");
            return (Criteria) this;
        }

        public Criteria andApplyStateIsNull() {
            addCriterion("apply_state is null");
            return (Criteria) this;
        }

        public Criteria andApplyStateIsNotNull() {
            addCriterion("apply_state is not null");
            return (Criteria) this;
        }

        public Criteria andApplyStateEqualTo(String value) {
            addCriterion("apply_state =", value, "applyState");
            return (Criteria) this;
        }

        public Criteria andApplyStateNotEqualTo(String value) {
            addCriterion("apply_state <>", value, "applyState");
            return (Criteria) this;
        }

        public Criteria andApplyStateGreaterThan(String value) {
            addCriterion("apply_state >", value, "applyState");
            return (Criteria) this;
        }

        public Criteria andApplyStateGreaterThanOrEqualTo(String value) {
            addCriterion("apply_state >=", value, "applyState");
            return (Criteria) this;
        }

        public Criteria andApplyStateLessThan(String value) {
            addCriterion("apply_state <", value, "applyState");
            return (Criteria) this;
        }

        public Criteria andApplyStateLessThanOrEqualTo(String value) {
            addCriterion("apply_state <=", value, "applyState");
            return (Criteria) this;
        }

        public Criteria andApplyStateLike(String value) {
            addCriterion("apply_state like", value, "applyState");
            return (Criteria) this;
        }

        public Criteria andApplyStateNotLike(String value) {
            addCriterion("apply_state not like", value, "applyState");
            return (Criteria) this;
        }

        public Criteria andApplyStateIn(List<String> values) {
            addCriterion("apply_state in", values, "applyState");
            return (Criteria) this;
        }

        public Criteria andApplyStateNotIn(List<String> values) {
            addCriterion("apply_state not in", values, "applyState");
            return (Criteria) this;
        }

        public Criteria andApplyStateBetween(String value1, String value2) {
            addCriterion("apply_state between", value1, value2, "applyState");
            return (Criteria) this;
        }

        public Criteria andApplyStateNotBetween(String value1, String value2) {
            addCriterion("apply_state not between", value1, value2, "applyState");
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