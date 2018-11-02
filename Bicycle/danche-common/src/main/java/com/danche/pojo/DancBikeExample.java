package com.danche.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DancBikeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DancBikeExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andBikeidIsNull() {
            addCriterion("bikeid is null");
            return (Criteria) this;
        }

        public Criteria andBikeidIsNotNull() {
            addCriterion("bikeid is not null");
            return (Criteria) this;
        }

        public Criteria andBikeidEqualTo(String value) {
            addCriterion("bikeid =", value, "bikeid");
            return (Criteria) this;
        }

        public Criteria andBikeidNotEqualTo(String value) {
            addCriterion("bikeid <>", value, "bikeid");
            return (Criteria) this;
        }

        public Criteria andBikeidGreaterThan(String value) {
            addCriterion("bikeid >", value, "bikeid");
            return (Criteria) this;
        }

        public Criteria andBikeidGreaterThanOrEqualTo(String value) {
            addCriterion("bikeid >=", value, "bikeid");
            return (Criteria) this;
        }

        public Criteria andBikeidLessThan(String value) {
            addCriterion("bikeid <", value, "bikeid");
            return (Criteria) this;
        }

        public Criteria andBikeidLessThanOrEqualTo(String value) {
            addCriterion("bikeid <=", value, "bikeid");
            return (Criteria) this;
        }

        public Criteria andBikeidLike(String value) {
            addCriterion("bikeid like", value, "bikeid");
            return (Criteria) this;
        }

        public Criteria andBikeidNotLike(String value) {
            addCriterion("bikeid not like", value, "bikeid");
            return (Criteria) this;
        }

        public Criteria andBikeidIn(List<String> values) {
            addCriterion("bikeid in", values, "bikeid");
            return (Criteria) this;
        }

        public Criteria andBikeidNotIn(List<String> values) {
            addCriterion("bikeid not in", values, "bikeid");
            return (Criteria) this;
        }

        public Criteria andBikeidBetween(String value1, String value2) {
            addCriterion("bikeid between", value1, value2, "bikeid");
            return (Criteria) this;
        }

        public Criteria andBikeidNotBetween(String value1, String value2) {
            addCriterion("bikeid not between", value1, value2, "bikeid");
            return (Criteria) this;
        }

        public Criteria andUserIsNull() {
            addCriterion("user is null");
            return (Criteria) this;
        }

        public Criteria andUserIsNotNull() {
            addCriterion("user is not null");
            return (Criteria) this;
        }

        public Criteria andUserEqualTo(String value) {
            addCriterion("user =", value, "user");
            return (Criteria) this;
        }

        public Criteria andUserNotEqualTo(String value) {
            addCriterion("user <>", value, "user");
            return (Criteria) this;
        }

        public Criteria andUserGreaterThan(String value) {
            addCriterion("user >", value, "user");
            return (Criteria) this;
        }

        public Criteria andUserGreaterThanOrEqualTo(String value) {
            addCriterion("user >=", value, "user");
            return (Criteria) this;
        }

        public Criteria andUserLessThan(String value) {
            addCriterion("user <", value, "user");
            return (Criteria) this;
        }

        public Criteria andUserLessThanOrEqualTo(String value) {
            addCriterion("user <=", value, "user");
            return (Criteria) this;
        }

        public Criteria andUserLike(String value) {
            addCriterion("user like", value, "user");
            return (Criteria) this;
        }

        public Criteria andUserNotLike(String value) {
            addCriterion("user not like", value, "user");
            return (Criteria) this;
        }

        public Criteria andUserIn(List<String> values) {
            addCriterion("user in", values, "user");
            return (Criteria) this;
        }

        public Criteria andUserNotIn(List<String> values) {
            addCriterion("user not in", values, "user");
            return (Criteria) this;
        }

        public Criteria andUserBetween(String value1, String value2) {
            addCriterion("user between", value1, value2, "user");
            return (Criteria) this;
        }

        public Criteria andUserNotBetween(String value1, String value2) {
            addCriterion("user not between", value1, value2, "user");
            return (Criteria) this;
        }

        public Criteria andPswordIsNull() {
            addCriterion("psword is null");
            return (Criteria) this;
        }

        public Criteria andPswordIsNotNull() {
            addCriterion("psword is not null");
            return (Criteria) this;
        }

        public Criteria andPswordEqualTo(String value) {
            addCriterion("psword =", value, "psword");
            return (Criteria) this;
        }

        public Criteria andPswordNotEqualTo(String value) {
            addCriterion("psword <>", value, "psword");
            return (Criteria) this;
        }

        public Criteria andPswordGreaterThan(String value) {
            addCriterion("psword >", value, "psword");
            return (Criteria) this;
        }

        public Criteria andPswordGreaterThanOrEqualTo(String value) {
            addCriterion("psword >=", value, "psword");
            return (Criteria) this;
        }

        public Criteria andPswordLessThan(String value) {
            addCriterion("psword <", value, "psword");
            return (Criteria) this;
        }

        public Criteria andPswordLessThanOrEqualTo(String value) {
            addCriterion("psword <=", value, "psword");
            return (Criteria) this;
        }

        public Criteria andPswordLike(String value) {
            addCriterion("psword like", value, "psword");
            return (Criteria) this;
        }

        public Criteria andPswordNotLike(String value) {
            addCriterion("psword not like", value, "psword");
            return (Criteria) this;
        }

        public Criteria andPswordIn(List<String> values) {
            addCriterion("psword in", values, "psword");
            return (Criteria) this;
        }

        public Criteria andPswordNotIn(List<String> values) {
            addCriterion("psword not in", values, "psword");
            return (Criteria) this;
        }

        public Criteria andPswordBetween(String value1, String value2) {
            addCriterion("psword between", value1, value2, "psword");
            return (Criteria) this;
        }

        public Criteria andPswordNotBetween(String value1, String value2) {
            addCriterion("psword not between", value1, value2, "psword");
            return (Criteria) this;
        }

        public Criteria andDesIsNull() {
            addCriterion("des is null");
            return (Criteria) this;
        }

        public Criteria andDesIsNotNull() {
            addCriterion("des is not null");
            return (Criteria) this;
        }

        public Criteria andDesEqualTo(String value) {
            addCriterion("des =", value, "des");
            return (Criteria) this;
        }

        public Criteria andDesNotEqualTo(String value) {
            addCriterion("des <>", value, "des");
            return (Criteria) this;
        }

        public Criteria andDesGreaterThan(String value) {
            addCriterion("des >", value, "des");
            return (Criteria) this;
        }

        public Criteria andDesGreaterThanOrEqualTo(String value) {
            addCriterion("des >=", value, "des");
            return (Criteria) this;
        }

        public Criteria andDesLessThan(String value) {
            addCriterion("des <", value, "des");
            return (Criteria) this;
        }

        public Criteria andDesLessThanOrEqualTo(String value) {
            addCriterion("des <=", value, "des");
            return (Criteria) this;
        }

        public Criteria andDesLike(String value) {
            addCriterion("des like", value, "des");
            return (Criteria) this;
        }

        public Criteria andDesNotLike(String value) {
            addCriterion("des not like", value, "des");
            return (Criteria) this;
        }

        public Criteria andDesIn(List<String> values) {
            addCriterion("des in", values, "des");
            return (Criteria) this;
        }

        public Criteria andDesNotIn(List<String> values) {
            addCriterion("des not in", values, "des");
            return (Criteria) this;
        }

        public Criteria andDesBetween(String value1, String value2) {
            addCriterion("des between", value1, value2, "des");
            return (Criteria) this;
        }

        public Criteria andDesNotBetween(String value1, String value2) {
            addCriterion("des not between", value1, value2, "des");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("status like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("status not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andCreatedIsNull() {
            addCriterion("created is null");
            return (Criteria) this;
        }

        public Criteria andCreatedIsNotNull() {
            addCriterion("created is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedEqualTo(Date value) {
            addCriterion("created =", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedNotEqualTo(Date value) {
            addCriterion("created <>", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedGreaterThan(Date value) {
            addCriterion("created >", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedGreaterThanOrEqualTo(Date value) {
            addCriterion("created >=", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedLessThan(Date value) {
            addCriterion("created <", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedLessThanOrEqualTo(Date value) {
            addCriterion("created <=", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedIn(List<Date> values) {
            addCriterion("created in", values, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedNotIn(List<Date> values) {
            addCriterion("created not in", values, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedBetween(Date value1, Date value2) {
            addCriterion("created between", value1, value2, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedNotBetween(Date value1, Date value2) {
            addCriterion("created not between", value1, value2, "created");
            return (Criteria) this;
        }

        public Criteria andUpdaredIsNull() {
            addCriterion("updared is null");
            return (Criteria) this;
        }

        public Criteria andUpdaredIsNotNull() {
            addCriterion("updared is not null");
            return (Criteria) this;
        }

        public Criteria andUpdaredEqualTo(Date value) {
            addCriterion("updared =", value, "updared");
            return (Criteria) this;
        }

        public Criteria andUpdaredNotEqualTo(Date value) {
            addCriterion("updared <>", value, "updared");
            return (Criteria) this;
        }

        public Criteria andUpdaredGreaterThan(Date value) {
            addCriterion("updared >", value, "updared");
            return (Criteria) this;
        }

        public Criteria andUpdaredGreaterThanOrEqualTo(Date value) {
            addCriterion("updared >=", value, "updared");
            return (Criteria) this;
        }

        public Criteria andUpdaredLessThan(Date value) {
            addCriterion("updared <", value, "updared");
            return (Criteria) this;
        }

        public Criteria andUpdaredLessThanOrEqualTo(Date value) {
            addCriterion("updared <=", value, "updared");
            return (Criteria) this;
        }

        public Criteria andUpdaredIn(List<Date> values) {
            addCriterion("updared in", values, "updared");
            return (Criteria) this;
        }

        public Criteria andUpdaredNotIn(List<Date> values) {
            addCriterion("updared not in", values, "updared");
            return (Criteria) this;
        }

        public Criteria andUpdaredBetween(Date value1, Date value2) {
            addCriterion("updared between", value1, value2, "updared");
            return (Criteria) this;
        }

        public Criteria andUpdaredNotBetween(Date value1, Date value2) {
            addCriterion("updared not between", value1, value2, "updared");
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