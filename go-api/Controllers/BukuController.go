package Controllers

import (
	"fmt"
	"net/http"

	"github.com/gin-gonic/gin"
	"perpus.com/m/Models"
)

//GetUBuku ... Get all users
//GetUsers ... Get all users
func GetBuku(c *gin.Context) {
	var buku []Models.Buku
	err := Models.GetAllBooks(&buku)
	if err != nil {
		c.AbortWithStatus(http.StatusNotFound)
	} else {
		c.JSON(http.StatusOK, buku)
	}
}

// CreateUser ... Create User
func CreateBook(c *gin.Context) {
	var Buku Models.Buku
	c.BindJSON(&Buku)
	err := Models.CreateBook(&Buku)
	if err != nil {
		fmt.Println(err.Error())
		c.AbortWithStatus(http.StatusNotFound)
	} else {
		c.JSON(http.StatusOK, Buku)
	}
}

//GetUserByID ... Get the user by id
func GetBookId(c *gin.Context) {
	id := c.Params.ByName("namaBuku")
	var book Models.Buku
	err := Models.GetBookByID(&book, id)
	if err != nil {
		c.AbortWithStatus(http.StatusNotFound)
	} else {
		c.JSON(http.StatusOK, book)
	}
}

// //UpdateUser ... Update the user information
// func UpdateUser(c *gin.Context) {
//  var user Models.User
//  id := c.Params.ByName("id")
//  err := Models.GetUserByID(&user, id)
//  if err != nil {
//   c.JSON(http.StatusNotFound, user)
//  }
//  c.BindJSON(&user)
//  err = Models.UpdateUser(&user, id)
//  if err != nil {
//   c.AbortWithStatus(http.StatusNotFound)
//  } else {
//   c.JSON(http.StatusOK, user)
//  }
// }
// //DeleteUser ... Delete the user
// func DeleteUser(c *gin.Context) {
//  var user Models.User
//  id := c.Params.ByName("id")
//  err := Models.DeleteUser(&user, id)
//  if err != nil {
//   c.AbortWithStatus(http.StatusNotFound)
//  } else {
//   c.JSON(http.StatusOK, gin.H{"id" + id: "is deleted"})
//  }
// }
