<template>
    <body id="paper">
      <el-form class="login-container" label-postion="left" label-width="0px" v-loading="loading">
        <h3 class="login_title">user register</h3>
        <el-form-item>
          <el-input type="text" v-model="loginForm.username" auto-complete="off" placeholder="账号"></el-input>
        </el-form-item>
        <el-form-item>
          <el-input type="password" v-model="loginForm.password" auto-complete="off" placeholder="密码"></el-input>
        </el-form-item>
        <el-form-item style="width: 100%">
          <el-button type="primary" style="width: 40%;background: #505458;border: none" v-on:click="register">注册</el-button>
        </el-form-item>
      </el-form>
    </body>
</template>

<script>
    export default {
        name: "Regist",
        data () {
            return {
                checked: true,
                loginForm: {
                    username: '',
                    password: ''
                },
                loading: false
            }
        },
        methods: {
            register () {
                var _this = this
                this.$axios
                    .post('/register', {
                        username: this.loginForm.username,
                        password: this.loginForm.password
                    })
                    .then(resp => {
                        if (resp.data.code === 200) {
                            this.$alert('注册成功', '提示', {
                                confirmButtonText: '确定'
                            })
                            _this.$router.replace('/login')
                        } else {
                            this.$alert(resp.data.message, '提示', {
                                confirmButtonText: '确定'
                            })
                        }
                    })
                    .catch(failResponse => {})
            }
        }
    }
</script>

<style scoped>

</style>
