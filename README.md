Goal:
Goal of the PoC is to implement all 9 Mobile Apis from Release 1 so that they can be used in Prod. 
This will have no dependency of Fineract but will implement NFR present in Fineract (Identity)
Work needs to done by MW: 
PoC is using JDK API to hash password while Fineract is using different algo. 
MW hs to modify reset password and created user code in user module so that to incorporate same JDK API to hash. 
And reset password for all existing users in user management module. 
