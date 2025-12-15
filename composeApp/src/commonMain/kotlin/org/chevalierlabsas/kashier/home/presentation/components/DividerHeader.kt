package org.chevalierlabsas.kashier.home.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun DividerHeader(
    title: String,
    isExpanded: Boolean,
    modifier: Modifier = Modifier,
    onToggle: () -> Unit
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .clickable { onToggle() }
            .padding(vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurface
        )

        Spacer(modifier = Modifier.width(12.dp))

        Divider(
            modifier = Modifier.weight(1f),
            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f)
        )

        Icon(
            imageVector = if (isExpanded)
                Icons.Default.KeyboardArrowUp
            else
                Icons.Default.KeyboardArrowDown,
            contentDescription = "Toggle",
            tint = MaterialTheme.colorScheme.onSurface,
            modifier = Modifier.padding(start = 8.dp)
        )
    }
}

@Preview
@Composable
fun DividerHeaderPreview() {
    Surface {
        DividerHeader(
            title = "Semua barang",
            isExpanded = true,
            modifier = Modifier.padding(16.dp),
            onToggle = {}
        )
    }
}
