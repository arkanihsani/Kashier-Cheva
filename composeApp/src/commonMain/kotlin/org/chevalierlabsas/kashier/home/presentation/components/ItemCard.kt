package org.chevalierlabsas.kashier.home.presentation.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import org.chevalierlabsas.kashier.home.domain.Item
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun ItemCard(
    item: Item,
    modifier: Modifier = Modifier,
    onAddClick: () -> Unit,
    onEditClick: () -> Unit,
) {
    Surface(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp),
        shape = RoundedCornerShape(12.dp),
        color = MaterialTheme.colorScheme.secondary
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = item.nama,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSecondary
                )
                Text(
                    text = "Rp. ${item.price.toInt()}",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSecondary
                )
            }

            IconButton(onClick = onEditClick) {
                Icon(
                    imageVector = Icons.Default.Edit,
                    contentDescription = "Edit",
                    tint = MaterialTheme.colorScheme.onSecondary
                )
            }

            IconButton(onClick = onAddClick) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Add",
                    tint = MaterialTheme.colorScheme.onSecondary
                )
            }
        }
    }
}

@Preview
@Composable
fun ItemCardPreview() {
    Surface {
        ItemCard(
            item = Item(
                id = 1,
                userId = 1,
                nama = "Telur 0.5 KG",
                price = 12000.0
            ),
            modifier = Modifier.padding(16.dp),
            onAddClick = {},
            onEditClick = {}
        )
    }
}
