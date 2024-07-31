import React, { useState, useEffect } from 'react'
import './EmployeeListScreen.scss'
import { fetchEmployeeList, deleteEmployeeList } from '../../../utils/serviceUtils'
import Button from '../../atoms/Button/Button'

const EmployeeListScreen = () => {
  const [empList, setEmpList] = useState([])

  useEffect(() => {
    fetchEmployeeList(setEmpList)
  },[]);

  const updateRecord = (id) => {
    window.location.assign(`/add?id=${id}&action=update`)
  }
  const deleteRecord = (id) => {
    deleteEmployeeList(id)
    window.location.reload()
  }
  const addRecord = () => {
    window.location.assign("/add")
  }

  const footerBtnArr = [
    {
      name: "Update",
      action: updateRecord,
      type: "update"
    },
    {
      name: "Delete",
      action: deleteRecord,
      type: "delete"
    }
  ]
  const btnArr = [
    {
      name: "Add employee",
      action: addRecord,
      type: "add"
    }
  ]

  return (
    <div className="employeeListScreen">
      <div className="employeeListScreen__table">
        <h1>Employee List:</h1>
        <p><Button btnProp={btnArr} /></p>
        <table>
          <tr>
            <th>ID</th>
            <th>First name</th>
            <th>Last name</th>
            <th>Email</th>
            <th>Actions</th>
          </tr>
          {empList?.length && empList.map((item, index) => 
            <tr key={index}>
              <td>{item.id}</td>
              <td>{item.firstName}</td>
              <td>{item.lastName}</td>
              <td>{item.emailId}</td>
              <td><Button btnProp={footerBtnArr} origin="listFooter" ids={item.id} /></td>
            </tr>
          )}
        </table>
      </div>
    </div>
  )
}

export default EmployeeListScreen