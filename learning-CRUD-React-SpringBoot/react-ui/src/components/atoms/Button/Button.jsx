import React from 'react'
import './Button.scss'

const Button = ({btnProp, origin, ids}) => {

  const btnCallBackFxn = (action, id) => {
    action(id)
  }

  return (
    <div className={`buttonComp buttonGroup__${origin}`}>
        {btnProp?.length && btnProp.map((item, index) => 
            <button type="button" onClick={() => btnCallBackFxn(item.action, ids)} className={`buttonComp__btn buttonComp__${item.type} buttonComp__${origin}`} key={index}>
                {item.name}
            </button>
        )}
    </div>
  )
}

export default Button