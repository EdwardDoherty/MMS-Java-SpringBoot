@import com.MMS.MMS.dto.UserDTO

@param UserDTO loggedUser = new com.MMS.MMS.dto.UserDTO(new org.bson.types.ObjectId(), "User")

@template.head(title = "Test page")

<h1>Hello ${loggedUser.userName()}!</h1>