import Vue from 'vue'
import VueSelect from 'vue-select'
import SimpleValidation from 'simple-vue-validator'
Vue.use(SimpleValidation)

const validlib = {
    install: function(Vue) {
        Vue.component('valid-input', {
                // 声明 props
                props: {
                    name: [String, Number],
                    maxlen: {
                        type: Number,
                        default: 50
                    },
                    valid: Function,
                    value: [String, Number],
                    valid2: Function,
                    disabled: String,
                    placeholder: String,
                    password: Boolean
                },
                template: '<div v-else class="form-group col-lg-6" :class="{\'has-error\': validation.hasError(\'valueresult\') }"> \
			<label>{{$t(name)}}</label>\
			<span class="span-box">{{validation.firstError(\'valueresult\')}}</span>\
			<input class="form-control" :maxlength="maxlen"  v-model="valueresult" @input="update($event.target.value)" :disabled="disabled" \
					v-bind:placeholder="$t(placeholder)" :type="inputtype">\
			</div>',
                computed: {
                    inputtype: function() {
                        return this.password ? "password" : "";
                    }
                },
                mounted() {
                    this.$validate();
                },
                data() {
                    return {
                        valueresult: ''
                    }
                },
                watch: {
                    value(newval) {
                        this.valueresult = newval;
                    }
                },
                validators: {
                    valueresult: function(value) {
                        var rule = null;
                        if (this.valid2 != null) {
                            rule = this.valid2(value);
                        } else {
                            if (this.valid != null) {
                                rule = this.valid(SimpleValidation.Validator.value(value));
                            }
                        }
                        if (rule != null && rule != undefined) {
                            if (rule._messages.length == 0) {
                                this.$emit("onvalid", true, {
                                    name: this.name,
                                    rule: rule
                                });
                            } else {
                                this.$emit("onvalid", false, {
                                    name: this.name,
                                    rule: rule
                                });
                            }
                        }
                        return rule;
                    }
                },
                methods: {
                    update(val) {
                        this.$emit("input", val);
                    }
                }
            }),

            Vue.component('valid-area', {
                // 声明 props
                props: {
                    name: [String, Number],
                    maxlen: {
                        type: Number,
                        default: 50
                    },
                    valid: Function,
                    value: [String, Number],
                    valid2: Function,
                    disabled: String,
                    rows: {
                        type: Number,
                        default: 3
                    },
                    placeholder: String
                },
                template: '<div v-else class="form-group col-lg-6" :class="{\'has-error\': validation.hasError(\'valueresult\') }"> \
			<label>{{$t(name)}}</label>\
			<span class="span-box">{{validation.firstError(\'valueresult\')}}</span>\
			<textarea class="form-control" :maxlength="maxlen"  v-model="valueresult" @input="update($event.target.value)" :rows="rows" :disabled="disabled"\
						v-bind:placeholder="$t(placeholder)">\
			</div>',
                created() {},
                mounted() {
                    this.$validate();
                },
                data() {
                    return {
                        valueresult: ''
                    }
                },
                watch: {
                    value(newval) {
                        this.valueresult = newval;
                    }
                },
                validators: {
                    valueresult: function(value) {
                        var rule = null;
                        if (this.valid2 != null) {
                            rule = this.valid2(value);
                        } else {
                            if (this.valid != null) {
                                rule = this.valid(SimpleValidation.Validator.value(value));
                            }
                        }
                        if (rule != null && rule != undefined) {
                            if (rule._messages.length == 0) {
                                this.$emit("onvalid", true, {
                                    name: this.name,
                                    rule: rule
                                });
                            } else {
                                this.$emit("onvalid", false, {
                                    name: this.name,
                                    rule: rule
                                });
                            }
                        }
                        return rule;
                    }
                },
                methods: {
                    update(val) {
                        this.$emit("input", val);
                    }
                }
            }),

            Vue.component('valid-xselect', {
                // 声明 props
                props: ['name', 'selected', 'options', 'valid', 'valid2', 'disabled'],
                template: '<div class="form-group col-lg-6" :class="{\'has-error\': validation.hasError(\'selected\') }">\
					<label>{{$t(name)}}</label> \
					<span class="required">(*)</span>\
					<span class="span-box">{{validation.firstError(\'selected\')}}</span>\
					<v-select multiple v-model="selected" :options="options" :style="disabled==\'disabled\'?\'pointer-events: none;opacity: 1.2;\':\'\'">\
					</v-select>\
				</div>',
                created() {},
                mounted() {
                    this.$validate();
                },
                data() {
                    return {}
                },
                validators: {
                    selected: function(value) {
                        var rule = null;
                        if (this.valid2 != null)
                            rule = this.valid2(value);
                        else {
                            if (this.valid != null)
                                rule = this.valid(SimpleValidation.Validator.value(value));
                        }
                        if (rule != null && rule != undefined) {
                            if (rule._messages.length == 0) {
                                this.$emit("onvalid", true, {
                                    name: this.name,
                                    rule: rule
                                });
                            } else {
                                this.$emit("onvalid", false, {
                                    name: this.name,
                                    rule: rule
                                });
                            }
                        }
                        return rule;
                    }
                },
                methods: {}
            }),

            Vue.component('valid-select', {
                props: ['name', 'selected', 'options', 'valid', 'valid2', 'disabled'],
                template: '<div class="form-group col-lg-6" :class="{\'has-error\': validation.hasError(\'myselect\') }">\
									<label>{{$t(name)}}</label> \
									<span class="required">(*)</span>\
									<span class="span-box">{{validation.firstError(\'myselect\')}}</span>\
									<select class="form-control" v-model="myselect" @change="change()" ref="me" :disabled="disabled">	\
										<option v-for="type in options" v-bind:value="type.value">{{$t(type.locale)}}</option>\
									</select>\
								</div>',
                data() {
                    return {
                        myselect: []
                    };
                },
                mounted() {
                    this.myselect = this.selected;
                    this.$validate();
                },
                watch: {
                    selected(newval) {
                        this.myselect = newval;
                    }
                },
                validators: {
                    myselect: function(value) {
                        if (value != null) {
                            var rule = null;
                            if (this.valid2 != null) {
                                rule = this.valid2(value);
                            } else {
                                if (this.valid != null)
                                    rule = this.valid(SimpleValidation.Validator.value(value));
                            }
                            if (rule != null && rule != undefined) {
                                if (rule._messages.length == 0) {
                                    this.$emit("onvalid", true, {
                                        name: this.name,
                                        rule: rule
                                    });
                                } else {
                                    this.$emit("onvalid", false, {
                                        name: this.name,
                                        rule: rule
                                    });
                                }
                            }
                            return rule;
                        } else {
                            return null;
                        }
                    }
                },
                methods: {
                    change() {
                        this.$emit('input', this.myselect);
                    }
                }
            })
    }
};

export default validlib;