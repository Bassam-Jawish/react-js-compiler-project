// script.js
const ProductList = (setSelectedItem, items) => {
	return `
		<div class="product-list">
			${items.map(((product,idx) => `<div key=${product.id} class="product-item" onclick=(() => setSelectedItem(items[${idx}]))()>
				<img src=${product.image} alt=${product.name} class="product-image" />					
				<p class="product-name">
					${product.name}
				</p>
			</div>`)())}
		</div>
	`;
};

document.querySelector("#app").innerHTML = App();