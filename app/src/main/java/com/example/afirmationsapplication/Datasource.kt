package com.example.afirmationsapplication

class Datasource() {
    fun loadAffirmations(): List<Affirmation>{
        //hàm trả về 1 list chứa các affirmation
        return listOf<Affirmation>(
            Affirmation(R.string.affirmation1, R.drawable.affirmation1),
            Affirmation(R.string.affirmation2, R.drawable.affirmation2),
            Affirmation(R.string.affirmation3, R.drawable.affirmation3),
            Affirmation(R.string.affirmation4, R.drawable.affirmation4),
            Affirmation(R.string.affirmation5, R.drawable.affirmation5),
        )
    }
}
//Datasource này cung cấp một phương thức loadAffirmations() để tải danh sách các Affirmation.
// Mỗi Affirmation được tạo ra với một cặp tài nguyên chuỗi và tài nguyên hình ảnh tương ứng.