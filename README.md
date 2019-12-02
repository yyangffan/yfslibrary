# yfslibrary自己使用的类库
## 类库：
* 日期，MD5加密，图片保存  
* SharePreference，ToastUtil  
* 状态栏的字体颜色变化TItleUtils  
## View
**底栏框**  
**密码输入框**  
**圆形自定义CircleImageView**  
**右滑返回的Activity（继承BaseActivity）**    
**类似于商品规格选择的RecyclerView，放不下自动换行** 

***github中Readme的基本写法(https://blog.csdn.net/weixin_42795141/article/details/89322823)***

# 使用方法
**主项目添加
**allprojects {  
		repositories {  
			...  
			maven { url 'https://jitpack.io' }  
		}  
	}**  
  
**app项目添加**  	
**dependencies {  
	        implementation 'com.github.yyangffan:yfslibrary:Tag'  
	}**  
## 通过 https://jitpack.io  获取版本内容  
