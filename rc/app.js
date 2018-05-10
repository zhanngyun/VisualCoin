//app.js
App({
  onLaunch: function () {
    // 展示本地存储能力
    var logs = wx.getStorageSync('logs') || []
    logs.unshift(Date.now())
    wx.setStorageSync('logs', logs)

    // 登录
    wx.login({
      success: res => {
        var that = this
        // 发送 res.code 到后台换取 openId, sessionKey, unionId
        console.log("-=================================" + res.code)
        wx.request({
          url: 'https://suncloud.club/suncloud/weixin/auth', //仅为示例，并非真实的接口地址
          data: {
            code: res.code
          },
          header: {
            'content-type': 'application/json' // 默认值
          },
          success: function (res) {
            console.log("返回回来的信息-------------=============" + res.data.data.openid)
            if (res.data.data.openid) {
              that.globalData.openid = res.data.data.openid
            }

            if ('undefined' == typeof (res.data.userInfo)) {
              console.log("--------------==============获取用户信息")
              wx.getSetting({
                success: res => {
                  if (res.authSetting['scope.userInfo']) {
                    // 已经授权，可以直接调用 getUserInfo 获取头像昵称，不会弹框
                    wx.getUserInfo({
                      success: res => {
                        console.log("用户信息：" + res.userInfo)
                        // 可以将 res 发送给后台解码出 unionId
                        that.globalData.userInfo = res.userInfo

                        //将获取到的用户信息发送到服务器保存
                        wx.request({
                          url: 'https://suncloud.club/suncloud/weixin/save', //仅为示例，并非真实的接口地址
                          method: 'POST',
                          data: {
                            'openid': that.globalData.openid,
                            'nickName': res.userInfo.nickName,
                            'avatarUrl': res.userInfo.avatarUrl,
                            'gender': res.userInfo.gender,
                            'city': res.userInfo.city,
                            'province': res.userInfo.province,
                            'country': res.userInfo.country,
                            'language': res.userInfo.language
                          },
                          header: {
                            'content-type': 'application/x-www-form-urlencoded' // 默认值
                          },
                          success: function (res) {
                            console.log('信息是否保存成功！' + res.data.success)
                          }
                        })


                        // 由于 getUserInfo 是网络请求，可能会在 Page.onLoad 之后才返回
                        // 所以此处加入 callback 以防止这种情况
                        if (this.userInfoReadyCallback) {
                          this.userInfoReadyCallback(res)
                        }
                      }
                    })
                  }
                }
              })

            }
          }

        })



      }
    })

  },
  globalData: {
    openid: null,
    userInfo: null
  }
})