package com.example.studysmart.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.studysmart.domain.model.Subject

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SubjectListBottomSheet(
    sheetState: SheetState,
    isOpen: Boolean,
    subjects: List<Subject>,
    bottomSheetTitle: String = "Related to subject",
    onSubjectClicked: (Subject) -> Unit,
    onDismissRequest: () -> Unit
) {
    if (isOpen) {
        ModalBottomSheet(
            sheetState = sheetState,
            onDismissRequest = onDismissRequest,
            dragHandle = {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    BottomSheetDefaults.DragHandle()
                    Text(text = bottomSheetTitle)
                    Spacer(modifier = Modifier.height(10.dp))
                    Divider()
                }
            }
        ) {
            LazyColumn(
                contentPadding = PaddingValues(16.dp)
            ) {
                items(subjects) { subject ->
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable { onSubjectClicked(subject) }
                            .padding(8.dp)
                    ) {
                        Text(text = subject.name)
                    }
                }
                if (subjects.isEmpty()) {
                    item {
                        Text(
                            modifier = Modifier.padding(10.dp),
                            text = "Ready to begin? First, add a subject."
                        )
                    }
                }
            }
    }
    }
}