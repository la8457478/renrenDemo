# GIT COMMIT LOG 格式 #
	项目代码提交日志的重要性，不用重复了，目前我们的日志杂乱，不能清晰的知道代码commit提交的代码内容，所以我们在提交commit时，要求格式统一，内容简单明了.

**Commit message格式**

 &lt;type&gt;: &lt;subject&gt; 	

<空行>

 &lt;body&gt;

注意冒号后面有空格。

**type**

用于说明 commit 的类别，只允许使用下面7个标识。

	feat：  新功能（feature）
	fix：   修补bug
	docs：  文档（documentation）
	style： 格式（不影响代码运行的变动）
	refactor：重构（即不是新增功能，也不是修改bug的代码变动）
	test：  测试用例修改
	chore： 其他修改, 比如构建流程, 依赖管理.
	del:    删除代码</br>
	如果type为feat和fix，则该 commit 将肯定出现在 Change log 之中。

**subject**

	subject是 commit 目的的简短描述，不超过50个字符，且结尾不加句号（.）。

**body**

	body是详细描述本次改动的内容，在描述中，希望一行描述一个事情，不要一直追加描述。



**IDEA 插件Git Commit Template**	

![1558512173976](1558512173976.png)



![1558512269963](1558512269963.png)


**参考资料**

	[git使用技巧](https://github.com/521xueweihan/git-tips)</br>
	[Angular团队提交规范](https://github.com/angular/angular.js/blob/master/DEVELOPERS.md#-git-commit-guidelines )
