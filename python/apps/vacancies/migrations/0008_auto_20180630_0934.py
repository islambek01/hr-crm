# Generated by Django 2.0.6 on 2018-06-30 09:34

from django.db import migrations


class Migration(migrations.Migration):
    dependencies = [
        ('vacancies', '0007_vacancy_requierements'),
    ]

    operations = [
        migrations.RenameField(
            model_name='vacancy',
            old_name='requierements',
            new_name='requirements',
        ),
    ]