<div>
	<h3>Welcome, {{hCtrl.user.firstName}} {{hCtrl.user.lastName}} </h3>
	<h4>Our beloved <span ng-style="{'color': hCtrl.color}" >{{hCtrl.user.permission}}</span></h4>

	<div ng-show="hCtrm.user.permission == 'MEMBER'">
		<p>Want to see our<a ng-href="#/products">Products</a>?</p>
	</div>
	<div ng-show="hCtrl.user.permission == 'ADMIN'">
		<div>
			<h5>Here you can: </h5>
			<ul>
				<li><a ng-href="#/userManagement">Manage Users</a></li>
				<li><a ng-href="#/productManagement">Manage Products</a></li>
				<li><a ng-href="#/newsManagement">Manage News</a></li>
				<li><a href="" ng-click="logout()" >Logout</a></li>
			</ul>
		</div>
	</div>
</div>

