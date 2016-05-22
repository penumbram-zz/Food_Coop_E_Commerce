<div>
	<table style="width:100%;">
		<tr>
			<!--<td>-->
			<h1>Products</h1>
			<!--</td>-->
			<!--
				<td>
					<div class="onoffswitch" style="float: right; margin-right:10px;">
						<input ng-change="onOffSwitch()" type="checkbox" name="onoffswitch" class="onoffswitch-checkbox" id="myonoffswitch">
						<label class="onoffswitch-label" for="myonoffswitch">
							<span class="onoffswitch-inner"></span>
							<span class="onoffswitch-switch"></span>
						</label>
					</div>
				</td>
			-->
		</tr>
	</table>
	<div style="margin: 1%;">
		<div ng-repeat="p in pCtrl.products" style="margin: 1%; text-align: center;">
			<div class="col-md-3" style="border:1px solid #b2b2b2; padding:1%;">
				<h4>{{p.productName}}</h4>
				<p>{{p.productDescription}}</p>
				<img style="height:100px; width:auto;" ng-src="{{p.photoUrl}}">
				<p>{{p.price}}</p>
				<p>{{p.sellUnit}}</p>
				<p>{{p.quantity}}</p>
				<p>{{p.productDescription}}</p>
				<a href="" ng-click="showProducer(p.producer)">{{p.producer.firstName}} {{p.producer.lastName}}</a><br>
				<a href="" ng-show="pCtrl.isSalesSession" ng-click="addToBasket(p)">Add to Basket</a>
			</div>
		</div>
	</div>
</div>
