import { useState } from 'react';
import './App.css'

interface Product {
  id: number;
  name: string;
  price: number;
}

const PRODUCTS: Product[] = [
  {id:1,name:"Pen",price:10},
  {id:2,name:"Book",price:20},
  {id:3,name:"Bag",price:30}
];

function App() {
const [cart, setCart] = useState<Product[]>([])

const addItem = (item: Product) => {
  setCart([...cart, item])
}

const removeItem = (id: number) => {
  setCart(cart?.filter((item) => item?.id !== id))
}

  return (
    <>
      <div>
        <h1>Products</h1>
        <ul style={{display: "flex"}}>{PRODUCTS?.length ? PRODUCTS?.map((item, index) => {
          return (
          <li key={index} style={{listStyle: "none", margin: "1rem"}}>
            <h4>{item?.name}</h4>
            <h4>{item?.price}</h4>
            <button onClick={() => addItem(item)}>Add to cart</button>
          </li>
          )
        }) : null}</ul>
      </div>
      <div>
        <h1>Cart</h1>
        <ul style={{display: "flex"}}>
          {cart?.length ? cart?.map((item, index) => {
            return(
              <li key={index} style={{listStyle: "none", margin: "1rem"}}>
                <h4>{item?.name}</h4>
                <h4>{item?.price}</h4>
                <button onClick={() => removeItem(item?.id)}>Remove</button>
              </li>
            )
          }) : null}
        </ul>
      </div>
    </>
  )
}

export default App
