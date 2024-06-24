// script.js
const Sidebar = (item, setSelectedItem) => 	{
		let 		content = `			<div class="side-section">
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
					<input type="range" min=295 max=3400 />						
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
			content = `				<button onclick=() => setSelectedItem(null)>
					${"x"}
				</button>
				<div class="sidebar-product">
					<img src=item.image alt=item.name />						
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

		return <aside class="sidebar">
				${content}
			</aside>;
		};

document.querySelector("#app").innerHTML = App();