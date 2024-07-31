export const fetchEmployeeList = async (setEmpList) => {
    const url = "http://localhost:8080/api/v1/employees"
  try {
    const response = await fetch(url)
    if (!response.ok) {
      throw new Error(`Response status: ${response.status}`)
    }
    setEmpList(await response.json())
  } catch (error) {
    console.error(error.message)
  }
}

export const deleteEmployeeList = (id) => {
  const url = `http://localhost:8080/api/v1/deleteEmployee/${id}`
    fetch(url, {
        method: "DELETE",
      })
        .then((response) => response.json())
        .then((json) => console.log(json));
}

export const saveEmployeeData = ( formData ) => {
    const url = "http://localhost:8080/api/v1/addEmployee"
    fetch(url, {
        method: "POST",
        body: JSON.stringify(formData),
        headers: {
          "Content-type": "application/json; charset=UTF-8"
        }
      })
        .then((response) => response.json())
        .then((json) => console.log(json));
}

export const getEmployeeData = async ( ids, setFirstName, setLastName, seEmailId ) => {
  const url = `http://localhost:8080/api/v1/getEmployee/${ids}`
  try {
    const response = await fetch(url)
    if (!response.ok) {
      throw new Error(`Response status: ${response.status}`)
    }
    const {emailId, firstName, lastName} = await response.json()
    setFirstName(firstName)
    setLastName(lastName)
    seEmailId(emailId)

  } catch (error) {
    console.error(error.message)
  }
}

export const updateEmployeeData = ( formData, ids ) => {
  const url = `http://localhost:8080/api/v1/updateEmployee/${ids}`
    fetch(url, {
        method: "PUT",
        body: JSON.stringify(formData),
        headers: {
          "Content-type": "application/json; charset=UTF-8"
        }
      })
        .then((response) => response.json())
        .then((json) => console.log(json));
}