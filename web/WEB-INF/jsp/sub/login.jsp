<div>
	<div style="width: 300px;" ng-hide="ctrl.success">
		<div class="login">
			<h1>Login</h1>
			<form name="form" ng-submit="ctrl.login(user)" role="form">
				<div class="form-group">
					<label for="username">Username</label>
					<i class="fa fa-key"></i>
					<input type="text" name="username" id="username" class="form-control" ng-model="user.username" required />
					<span ng-show="form.username.$dirty && form.username.$error.required" class="help-block">Username is required</span>
				</div>
				<div class="form-group">
					<label for="password">Password</label>
					<i class="fa fa-lock"></i>
					<input type="password" name="password" id="password" class="form-control" ng-model="user.password" required />
					<span ng-show="form.password.$dirty && form.password.$error.required" class="help-block">Password is required</span>
				</div>
				<span ng-show="!ctrl.success" class="has-error">Wrong Credentials</span>
				<div class="form-actions">
					<button type="submit" ng-disabled="form.$invalid || dataLoading" class="btn btn-danger">Login</button>
				</div>
			</form>
		</div>
	</div>
</div>
