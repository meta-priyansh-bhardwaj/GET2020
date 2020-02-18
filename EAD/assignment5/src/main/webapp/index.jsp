<html>
<head>
	<title>Shopping Cart</title>
</head>
<style>
	table, tr, th, td{
		padding: 25px;
		border: solid 1px black;
	}
	table{
		margin-left: auto;
		margin-right: auto;
	}
	h1, h3{
		text-align: center;
	}
	h1{
		margin-top: 50px;
		margin-bottom: 0;
	}
</style>
<body>
    <h1>Stock</h1>
    <table id="stockTable">
    	<tr>
    		<th>Product Code</th>
    		<th>Name</th>
    		<th>Type</th>
    		<th>Price</th>
    	</tr>
    </table>
    <h1>Cart</h1>
    <table id="cartTable">
    	<tr>
    		<th>Name</th>
    		<th>Quantity</th>
    	</tr>
    </table>
    <h3>Price: Rs <span id="bill">0.0</span></h3>
    <h1>Add Product</h1>
    <table id="addProduct">
    	<tr>
    		<th>Name</th>
    		<td>
    			<select id="selectAddProduct" onchange="validateAddProduct()">
    				<option disabled value="" selected>Select an Option</option>
    			</select>
    		</td>
    	</tr>
    	<tr>
    		<th>Quantity</th>
    		<td>
    			<input onkeyup="validateAddProduct()" id="quantityAddProduct" type="number" placeholder="Enter quantity to add" />
    		</td>
    	</tr>
    	<tr>
    		<td colSpan="2"><button disabled id="addProductButton" type="button" onclick="submitAddProduct()">Add</button></td>
    	</tr>
    </table>
    
    <h1>Delete Product</h1>
    <table id="deleteProduct">
    	<tr>
    		<th>Name</th>
    		<td>
    			<select onchange="validateDeleteProduct()" id="selectDeleteProduct">
    				<option disabled value="" selected>Select an Option</option>
    			</select>
    		</td>
    	</tr>
    	<tr>
    		<th>Quantity</th>
    		<td>
    			<input onkeyup="validateDeleteProduct()" id="quantityDeleteProduct" type="number" placeholder="Enter quantity to delete" />
    		</td>
    	</tr>
    	<tr>
    		<td colSpan="2"><button onclick="submitDeleteProduct()" disabled id="deleteProductButton" type="button">Delete</button></td>
    	</tr>
    </table>
    
    <h1>Edit Quantity</h1>
    <table id="editProduct">
    	<tr>
    		<th>Name</th>
    		<td>
    			<select onchange="validateEditProduct()" id="selectEditProduct">
    				<option disabled value="" selected>Select an Option</option>
    			</select>
    		</td>
    	</tr>
    	<tr>
    		<th>Quantity</th>
    		<td>
    			<input onkeyup="validateEditProduct()" id="quantityEditProduct" type="number" placeholder="Enter quantity to edit" />
    		</td>
    	</tr>
    	<tr>
    		<td colSpan="2"><button onclick="submitEditProduct()" disabled id="editProductButton" type="button">Edit</button></td>
    	</tr>
    </table>
</body>
<script>
	const getStock = async() => {
		const response = await fetch('http://localhost:8080/assignment5/webapi/shopping-cart/stock');
		const data = await response.json();
		let stockTable = document.getElementById('stockTable');
		let addTable = document.getElementById('selectAddProduct');
		for(let key in data){
			var tr = document.createElement("TR");
			var productCode = document.createElement("TD");
			var name = document.createElement("TD");
			var type = document.createElement("TD");
			var price = document.createElement("TD");
			let option = document.createElement("option");
			option.text = key;
			option.value = key;
			
			productCode.appendChild(document.createTextNode(data[key].productCode));
			name.appendChild(document.createTextNode(data[key].name));
			type.appendChild(document.createTextNode(data[key].type));
			price.appendChild(document.createTextNode(data[key].price));
			tr.appendChild(productCode);
			tr.appendChild(name);
			tr.appendChild(type);
			tr.appendChild(price);
			stockTable.appendChild(tr);
			addTable.add(option);
		}
	}
	
	const getCart = async() => {
		const response = await fetch('http://localhost:8080/assignment5/webapi/shopping-cart');
		const data = await response.json();
		let cartTable = document.getElementById('cartTable');
		let deleteTable = document.getElementById('selectDeleteProduct');
		let editTable = document.getElementById('selectEditProduct');
		
		
		for(let i=deleteTable.options.length-1;i>0;i--){
			deleteTable.options[i]=null;
			editTable.options[i]=null;
			cartTable.removeChild(cartTable.childNodes[i+1]);
		}
		for(let key in data){
			var tr = document.createElement("TR");
			var name = document.createElement("TD");
			var quantity = document.createElement("TD");
			let option = document.createElement("option");
			option.text = key;
			option.value = key;
			let option_ = document.createElement("option");
			option_.text = key;
			option_.value = key;
			
			name.appendChild(document.createTextNode(key));
			quantity.appendChild(document.createTextNode(data[key]));
			tr.appendChild(name);
			tr.appendChild(quantity);
			cartTable.appendChild(tr);
			deleteTable.add(option);
			editTable.add(option_);
		}
		const responseForBill = await fetch('http://localhost:8080/assignment5/webapi/shopping-cart/bill');
		const dataForBill = await responseForBill.json();
		document.getElementById("bill").innerHTML = dataForBill;
	}
	
	getStock();
	getCart();
	
	const submitAddProduct = async() => {
		let name = document.getElementById("selectAddProduct").value;
		let quantity = Number(document.getElementById("quantityAddProduct").value);
		const response = await fetch("http://localhost:8080/assignment5/webapi/shopping-cart/",{
			method: 'POST',
			headers: {
				'Content-Type': 'application/json'
			},
			body: JSON.stringify({name: name, quantity: quantity})
		});
		document.getElementById("selectAddProduct").value = "";
		document.getElementById("quantityAddProduct").value = "";

		getCart();
	}
	const submitDeleteProduct = async() => {
		let name = document.getElementById("selectDeleteProduct").value;
		let quantity = Number(document.getElementById("quantityDeleteProduct").value);
		const response = await fetch("http://localhost:8080/assignment5/webapi/shopping-cart/"+name,{
			method: 'DELETE',
			headers: {
				'Content-Type': 'application/json'
			},
			body: JSON.stringify({quantity: quantity})
		});
		document.getElementById("selectDeleteProduct").value = "";
		document.getElementById("quantityDeleteProduct").value = "";

		getCart();
	}
	const submitEditProduct = async() => {
		let name = document.getElementById("selectEditProduct").value;
		let quantity = Number(document.getElementById("quantityEditProduct").value);
		const response = await fetch("http://localhost:8080/assignment5/webapi/shopping-cart/"+name,{
			method: 'PUT',
			headers: {
				'Content-Type': 'application/json'
			},
			body: JSON.stringify({quantity: quantity})
		});
		document.getElementById("selectEditProduct").value = "";
		document.getElementById("quantityEditProduct").value = "";

		getCart();
	}
	
	const validateAddProduct = () => {
		let name = document.getElementById("selectAddProduct").value;
		let quantity = document.getElementById("quantityAddProduct").value;
		if(name!=="" && quantity!==""){
			document.getElementById("addProductButton").disabled = false;
		} else {
			document.getElementById("addProductButton").disabled = true;
		}
	}
	const validateDeleteProduct = () => {
		let name = document.getElementById("selectDeleteProduct").value;
		let quantity = document.getElementById("quantityDeleteProduct").value;
		if(name!=="" && quantity!==""){
			document.getElementById("deleteProductButton").disabled = false;
		} else {
			document.getElementById("deleteProductButton").disabled = true;
		}
	}
	const validateEditProduct = () => {
		let name = document.getElementById("selectEditProduct").value;
		let quantity = document.getElementById("quantityEditProduct").value;
		if(name!=="" && quantity!==""){
			document.getElementById("editProductButton").disabled = false;
		} else {
			document.getElementById("editProductButton").disabled = true;
		}
	}
</script>
</html>
