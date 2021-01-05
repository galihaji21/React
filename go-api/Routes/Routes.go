package Routes

import (
	"perpus.com/m/Controllers"

	"github.com/gin-gonic/gin"
)

//SetupRouter ... Configure routes
func SetupRouter() *gin.Engine {
	r := gin.Default()
	grp1 := r.Group("/buku-api")
	{
		grp1.GET("/getBuku", Controllers.GetBuku)
		grp1.POST("/postBuku", Controllers.CreateBook)
		grp1.GET("buku/:id", Controllers.GetBookId)
		// grp1.PUT("user/:id", Controllers.UpdateUser)
		// grp1.DELETE("user/:id", Controllers.DeleteUser)
	}
	return r
}
