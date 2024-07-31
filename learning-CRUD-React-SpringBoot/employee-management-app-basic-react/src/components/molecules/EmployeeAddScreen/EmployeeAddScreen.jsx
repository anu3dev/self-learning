import React, { useState, useEffect } from 'react'
import './EmployeeAddScreen.scss'
import Button from '../../atoms/Button/Button'
import { saveEmployeeData, getEmployeeData, updateEmployeeData } from "../../../utils/serviceUtils"

const EmployeeAddScreen = () => {
  const urlParams = new URLSearchParams(window.location.search)
  const actionVal = urlParams.get('action') || ''
  const idVal = urlParams.get('id') || null

  const isUpdateAction = actionVal === 'update'

  const [firstName, setFirstName] = useState("")
  const [lastName, setLastName] = useState("")
  const [emailId, seEmailId] = useState("")

  useEffect(() => {
    if(isUpdateAction)
    getEmployeeData(idVal, setFirstName, setLastName, seEmailId)
  },[idVal, isUpdateAction]);

  const saveRecord = () => {
    const formData = {
      firstName: firstName,
      lastName: lastName,
      emailId: emailId
    }

    isUpdateAction ? updateEmployeeData(formData, idVal) : saveEmployeeData(formData)
    window.location.assign("/")
  }
  const backBtn = () => {
    window.location.assign("/")
  }

  const footerBtnArr = [
    {
      name: "Save",
      action: saveRecord,
      type: "save"
    },
    {
      name: "Cancel",
      action: backBtn,
      type: "cancel"
    }
  ]

  const headingVal = `${isUpdateAction ? 'Update' : 'Add'} Employee`

  return (
    <div className="employeeAddScreen">
      <h1>{headingVal}</h1>
      <div className="employeeAddScreen__form">
        <form>
          <label>Enter your first name:
            <input
              type="text" 
              value={firstName}
              placeholder='Enter your first name'
              onChange={(e) => setFirstName(e.target.value)}
            />
          </label>
          <label>Enter your last name:
            <input
              type="text" 
              value={lastName}
              placeholder='Enter your last name'
              onChange={(e) => setLastName(e.target.value)}
            />
          </label>
          <label>Enter your email:
            <input
              type="email" 
              value={emailId}
              placeholder='Enter your email'
              onChange={(e) => seEmailId(e.target.value)}
            />
          </label>
        </form>
      </div>
      <Button btnProp={footerBtnArr} origin="addDetails" />
    </div>
  )
}

export default EmployeeAddScreen