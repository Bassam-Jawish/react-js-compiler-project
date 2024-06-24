// script.js
const products = [	{id: 1, name: "Nintendo", image: "file01.jpg", description: "Nintendo is a popular gaming platform that offers a variety of games and consoles."},	{id: 2, name: "Controllers", image: "file2.png", description: "Controllers enhance your gaming experience by providing more intuitive controls."},	{id: 3, name: "Laptops", image: "file3.jpg", description: "Laptops provide portability and convenience, allowing you to play games on the go."},	{id: 4, name: "Oculus", image: "file4.png", description: "Oculus offers virtual reality experiences that transport you to other worlds."},	{id: 5, name: "XBOX", image: "file22.jpg", description: "Xbox is a gaming console that offers a wide range of games and entertainment options."},	{id: 6, name: "Playstation", image: "file33.jpg", description: "Playstation is a gaming console known for its exclusive titles and robust online community."},	{id: 7, name: "Video Games", image: "file44.jpg", description: "Video games offer immersive experiences that can captivate players for hours."},	{id: 8, name: "Headsets", image: "file0.png", description: "Headsets allow you to immerse yourself in virtual reality experiences."},	{id: 9, name: "Keyboards", image: "file1.jpg", description: "Keyboards are essential for navigating through digital environments."},	{id: 10, name: "Chairs", image: "file2.jpg", description: "Comfortable chairs are essential for long gaming sessions."},	{id: 11, name: "Gaming Mice", image: "file11.jpg", description: "Gaming mice provide precise control for your games."},	{id: 12, name: "Apparel", image: "file4.jpg", description: "Apparel items can show off your favorite game characters."},	{id: 13, name: "Action Figures", image: "file0.jpg", description: "Action figures bring your favorite characters to life."},	{id: 14, name: "Hats", image: "file1.png", description: "Hats can be a fun way to express your love for gaming."},	{id: 15, name: "Mugs", image: "file3.png", description: "Mugs are a great way to start your day with a cup of coffee and a reminder of your favorite game."},];

const NavigationBar = ({items, setItems}) => {
	return `
		<nav class="navigation">
			<img src="file4.png" alt="icon" />				
			${SearchComponent({ items: items, setItems: setItems })}
		</nav>
	`;
};

function SearchComponent({items, setItems}) {
	window.searchTerm = window.searchTerm || "";
	window.setSearchTerm = function setSearchTerm(setSearchTerm) {
		window.searchTerm = setSearchTerm;
		document.querySelector("#app").innerHTML = App();
	};

	addEventListener('input', (event) => 	{
		if (!searchTerm) 
		{
			setItems(products)
		}
		else 
		{
			const results = items.filter((item) => item.name.toLowerCase().includes(searchTerm.toLowerCase()));

			setItems(results)
		}
		App();
	});

	return `
		<div class="search-bar">
			<input id="searchInput" type="text" placeholder="Search..." value="${searchTerm}" oninput="(() => setSearchTerm(event.target.value))()" />				
		</div>
	`;
}
const ProductList = ({setSelectedItem, items}) => {
	return `
		<div class="product-list">
			${items.map((product,idx) => `<div key="${product.id}" class="product-item" onclick="(() => setSelectedItem(items[${idx}]))()">
				<img src="${product.image}" alt="${product.name}" class="product-image" />					
				<p class="product-name">
					${product.name}
				</p>
			</div>`)}
		</div>
	`;
};

const Sidebar = ({item, setSelectedItem}) => {
	let 	content = `		<div class="side-section">
			<h2>
				Deparment
			</h2>
			<p>
				LaptopComputers
			</p>
		</div>
		<div class="side-section">
			<h2>
				Brands
			</h2>
			<div class="side-check">
				<div>
					<input type="checkbox" name="msi" />						
					<label htmlFor="msi">
						msi
					</label>
				</div>
				<div>
					<input type="checkbox" name="acer" />						
					<label htmlFor="acer">
						acer
					</label>
				</div>
				<div>
					<input type="checkbox" name="asus" />						
					<label htmlFor="asus">
						Asus
					</label>
				</div>
				<div>
					<input type="checkbox" name="HP" />						
					<label htmlFor="HP">
						HP
					</label>
				</div>
				<div>
					<input type="checkbox" name="Lenovo" />						
					<label htmlFor="Lenovo">
						Lenovo
					</label>
				</div>
				<div>
					<input type="checkbox" name="Dell" />						
					<label htmlFor="Dell">
						Dell
					</label>
				</div>
				<div>
					<input type="checkbox" name="LG" />						
					<label htmlFor="LG">
						LG
					</label>
				</div>
			</div>
		</div>
		<div class="side-section">
			<h2>
				LaptopPrice
			</h2>
			<p>
				2953,400+
			</p>
			<div>
				<input type="range" min="${295}" max="${100}" />					
			</div>
		</div>
		<div class="side-section">
			<h2>
				HardDiskSize
			</h2>
			<div class="side-check">
				<div>
					<input type="checkbox" name="4 TB & Above" />						
					<label htmlFor="4 TB & Above">
						4TB&Above
					</label>
				</div>
				<div>
					<input type="checkbox" name="2 TB" />						
					<label htmlFor="2 TB">
						2TB
					</label>
				</div>
				<div>
					<input type="checkbox" name="1 TB" />						
					<label htmlFor="1 TB">
						1TB
					</label>
				</div>
				<div>
					<input type="checkbox" name="501 to 999 GB" />						
					<label htmlFor="501 to 999 GB">
						501to999GB
					</label>
				</div>
				<div>
					<input type="checkbox" name="121 to 320 GB" />						
					<label htmlFor="121 to 320 GB">
						121to320GB
					</label>
				</div>
			</div>
		</div>
`;

	if (item != null) 
	{
		content = `			<button onclick="(() => setSelectedItem(null))()">
				${"x"}
			</button>
			<div class="sidebar-product">
				<img src="${item.image}" alt="${item.name}" />					
				<div>
					<h2>
						${item.name}
					</h2>
					<p>
						${item.description}
					</p>
				</div>
			</div>
`
	}

	return `
		<aside class="sidebar">
			${content}
		</aside>
	`;
};

const Panner = () => {
	return `
		<div class="panner">
			<img src="main-panel.png" alt="pic" />				
		</div>
	`;
};

const App = () => {
	const searchInput = document.querySelector('#searchInput');
	if (searchInput) {
		const length = searchInput.value.length;
		searchInput.focus();
		searchInput.setSelectionRange(length, length);
	}
	window.items = window.items || products;
	window.setItems = function setItems(setItems) {
		window.items = setItems;
		document.querySelector("#app").innerHTML = App();
	};

	window.slectedItem = window.slectedItem || null;
	window.setSelectedItem = function setSelectedItem(setSelectedItem) {
		window.slectedItem = setSelectedItem;
		document.querySelector("#app").innerHTML = App();
	};

	return `
		<div class="app">
			${NavigationBar({ items: items, setItems: setItems })}
			<div class="content">
				${Sidebar({ item: slectedItem, setSelectedItem: setSelectedItem })}
				<div class="catalog">
					${Panner()}
					${ProductList({ items: items, setSelectedItem: setSelectedItem })}
				</div>
			</div>
		</div>
	`;
};

document.querySelector("#app").innerHTML = App();