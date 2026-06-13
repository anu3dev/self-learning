import React from 'react';

const CartWidget = () => {
  const items = [{ id: 1, name: 'Pen' }, { id: 2, name: 'Book' }];
  return (
    <div>
      <strong>Cart</strong>
      <ul>
        {items.map(i => <li key={i.id}>{i.name}</li>)}
      </ul>
    </div>
  );
};

export default CartWidget;
