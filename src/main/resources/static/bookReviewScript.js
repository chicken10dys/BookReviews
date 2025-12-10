// Asynchronously fetch book info and reviews for the book
function getBook(id){
    fetch("http://localhost:8080/books/"+id)
        .then(data => data.json())
        .then(function(data){ showBook(data);})
    fetch("http://localhost:8080/reviews/search/findByBookId?id="+id)
        .then(data => data.json())
        .then(function(data){ showReviews(data);})
}

// Adds bookdata to bookdetails DOM
function showBook(bookdata){
    var bookDetails =
        "<br>Title: " +bookdata.title +
        "<br>Authors: " +bookdata.authors;
            document.getElementById("bookdetails").innerHTML=bookDetails;
}

// Adds review data to reviewdetails on DOM
function showReviews(data){
	// Check for no reviews. Add them to DOM 
    if (!data._embedded || !data._embedded.reviews || data._embedded.reviews.length === 0) {
        document.getElementById("reviewdetails").innerHTML = "<p>No reviews yet.</p>";
        return;
    }
	
	// If there are reviews, add them to DOM
    var reviewsList = data._embedded.reviews;
    var reviewsDetails = "<ul>";
    reviewsList.forEach((review) => {
        reviewsDetails += "<li>" + review.reviewText + "</li>";
    });
    reviewsDetails += "</ul>";
    document.getElementById("reviewdetails").innerHTML = reviewsDetails;
}