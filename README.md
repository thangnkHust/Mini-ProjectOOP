# Visualization Sorting Project
## Mini-project môn Object-Oriented Language and Theory
### Yêu cầu đề bài:
* Tạo ứng dụng trình diễn các thuật toán sắp xếp:
	* Bubble Sort
	* Selection Sort
	* Merge Sort
	* Bucket Sort
* Áp dụng các tính chất của hướng đối tượng vào việc thiết kế các class

### Thông tin thành viên & phân chia công việc
* Nguyễn Khắc Thắng - 20176869 - [Contact](https://www.facebook.com/thangfighting)
	* Thiết kế use-case diagram
	* Thiết kế class:
		* Chia pakage kèm theo chức năng chính của nó
		* Các class chính kèm theo chức năng cụ thể của nó
	* Áp dụng tính chất của OOP vào thiết kế class
	* Class ArrayVisualizer
	* Class SortVisualizer
	* Class Element, ElementBox, ElementIndex
	* Interface ISortAlgorithms
	* Class SelectionSort
	* Class MergeSort: Phần sortIncrease
	* Class BucketSort: Phần sortIncrease
* Võ Quang Thành Đạt - 20176714 - [Contact](https://www.facebook.com/profile.php?id=100006933034189)
	* Class VisualizerFrame:
		* Thông qua một vài cách design GUI từ một số open-source-code trên github
		* Chọn lọc và vẽ ra bản thiết kế giao diện tổng quát cho ứng dụng
	* Class BubbleSort:
		* Override các phương thức từ Interface ISortAlgorithms
		* Cài đặt PointRun (i, j chạy ở dưới)
	* Class MergeSort: Phần sortDecrease
	* Class BucketSort: Phần sortDecrease

### Use-case diagram
![use-case](https://bitbucket.org/thangnkHust/oolt.vn.20192.team7/src/master/design/UseCase%20Diagram.png)
### Class diagram
![class](https://bitbucket.org/thangnkHust/oolt.vn.20192.team7/src/master/design/Class%20Diagram%20ver3.0.png)
### Link video demo chạy chương trình
[Visualizer Sorting Algorithms Application](https://youtu.be/EN90QOKtSZI)