export const iterateTwoArray = () => {
  const main = [{name: 'anu'}, {name: 'rag'}, {name: 'nit'}]
  const match = ['anu', 'nit']

  const finalVal = []
  
  main.map((item) => {
    if(match.includes(item.name)){
      finalVal.push({...item, matched: true})
    } else {
      finalVal.push({...item, matched: false})
    }
    return finalVal
  })

  // console.log('finalVal', finalVal)
}



export const searchFromURL = () => {
  // add ?user=anu&age=24 after existing URL to test this method

  const urlSearch = new URLSearchParams(window.location.search)
  const user = urlSearch.get('user')
  const age = urlSearch.get('age')

  const details = `user is ${user} and age is ${age}`

  // console.log('details', details)
}



export const protoOne = () => {

  const list = new Map([
    ['fruits', ['mango', 'apple']],
    ['animal', ['cat', 'dog', 'goat']]
  ])

  const details = [{type: 'fruits'}, {type: 'animal'}, {type: 'city'}]

  const modifiedList = []

  details.map((item) => {
    const typeVal = list.get(item.type)

    if(typeVal?.length){
      modifiedList.push({...item, typeVal})
    } else {
      modifiedList.push({...item})
    }

    return modifiedList
  })

  // console.log('modifiedList', modifiedList)
}



export const protoTwo = () => {

  const mock = new Map()

  mock.set('user', 'anu')

  // console.log(mock.has('user')) // check before delete: true
  // console.log(mock.get('user')) // get before delete: anu
  // console.log(mock.size) // get size before delete: 1
  // console.log(mock.delete('user')) // delete value: true
  // console.log(mock.size) // get size after delete: 0
  // console.log(mock.has('user'))  // check after delete: false
  // console.log(mock.get('user')) // get after delete: undefined

  mock.set('0', 'anu')
  mock.set('1', 'rag')

  const entries = mock.entries()
  const keys = mock.keys()
  const values = mock.values()
  
  // console.log(entries.next().value) // ['0', 'anu']
  // console.log(entries.next().value) // ['1', 'rag']
  // console.log(keys.next().value) // 0
  // console.log(keys.next().value) // 1
  // console.log(values.next().value) // anu
  // console.log(values.next().value) // rag
}