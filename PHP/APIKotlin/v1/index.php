<?php 
	
	//adding dboperation file 
	require_once '../DbOperation.php';
	
	//response array 
	$response = array(); 
	
	if (empty($_POST['Cedula']) && empty($_POST['Apellidos']) && empty($_POST['Nombres']) && empty($_POST['Password'])) {
      $response['error'] = true; 
      $response['message'] = 'Campos Vacios al enviar los datos';

   } else {
      if (isset($_POST['Cedula']) && isset($_POST['Apellidos']) && isset($_POST['Nombres']) && isset($_POST['Password'])) {
         $db = new DbOperation(); 
         if($db->insertUser($_POST['Cedula'], $_POST['Apellidos'], $_POST['Nombres'], $_POST['Password'])){
            $response['error'] = false;
            $response['message'] = 'User added successfully';
         }else{
            $response['error'] = true;
            $response['message'] = 'Could not add User';
         }
         // }else{
         // 	$response['error'] = true; 
         // 	$response['message'] = 'Required Parameters are missing';
         // }	
      }else{
         $response['error'] = false; 
         $response['message'] = 'Invalid Request';
      }

   }
	
	//displaying the data in json 
   echo json_encode($response);
?>